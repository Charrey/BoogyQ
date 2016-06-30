package sprocl;

import java.util.*;

import generator.Generator;
import sprocl.model.*;
import toplevel.OpListWrapper;


/** Assembler for the ILOC language. */
public class Assembler {

	private static String s4 = "    "; 	//We need to use 4 spaces instead of a tab.
	private static String s8 = s4+s4;
	private static final String PREFIX = "core";

    public static String assemble(Map<Integer, Set<OpListWrapper>> map, String progname, OpListWrapper main) {
        StringBuilder sproclCode = new StringBuilder();
        sproclCode.append("module "+progname+" where\n" +
                "\n" +
                "import BasicFunctions\n" +
                "import HardwareTypes\n" +
                "import Sprockell\n" +
                "import System\n" +
                "import Simulation\n" +
                "\n" +
                "main :: IO()\n" +
                "main = sysTest [");
        boolean comma = false;
        for (int core : map.keySet()) {
            if (comma) {
            sproclCode.append(", ");
            }
            sproclCode.append(PREFIX + core);
            comma = true;
        }
        sproclCode.append("]");

		Reg r_0 = new Reg("0");
		Reg r_load = Generator.getInstance().r_load;
		Reg r_standard = Generator.getInstance().r_standard0;

		for (int core : map.keySet()) {
			boolean thisismain = false;
			for (OpListWrapper i : map.get(core)) {
				if (i.equals(main)) {
					assert map.get(core).size()==1;
					thisismain = true;
				}
			}
			sproclCode.append("\n\n" + PREFIX + core + " :: [Instruction]\n");
			sproclCode.append(PREFIX + core + " = [");
			List<Op> percore = new LinkedList<>();


			if (!thisismain) {
				List<OpListWrapper> opListWrappers = new LinkedList<>(map.get(core));


				List<List<Op>> concurrentBlocksOps = new ArrayList<>();
				List<Op> concurrentBlockOps;
				for (OpListWrapper wrap : opListWrappers) {
					concurrentBlockOps = new LinkedList<>();
					int memloc = wrap.getMemLocation();
					concurrentBlockOps.add(new Op(OpCode.loadCONST, new Num(memloc), r_load));
					concurrentBlockOps.add(new Op(OpCode.writeINDA, r_0, r_load));
					concurrentBlockOps.add(new Op(OpCode.readINDA, r_load));
					concurrentBlockOps.add(new Op(OpCode.receive, r_standard));
					concurrentBlockOps.addAll(wrap.getOps());
					concurrentBlockOps.add(new Op(OpCode.jumpABS, new Num(0)));
					concurrentBlocksOps.add(concurrentBlockOps);
				}

				int blockcodebefore = 0; //A simple counter to keep track how many concurrentblock operations
										// Were added before the current one.

				int totalprogsize = 0;
				for (int i = 0; i < opListWrappers.size(); i++) {
					totalprogsize += 10 + opListWrappers.get(i).getOps().size();
				}
				totalprogsize += 5;

				for (int i = 0; i < opListWrappers.size(); i++) {
					OpListWrapper wrap = opListWrappers.get(i);
					int memloc = wrap.getMemLocation();
					percore.add(new Op(OpCode.loadCONST, new Num(memloc), r_load));
					percore.add(new Op(OpCode.readINDA, r_load));
					percore.add(new Op(OpCode.receive, r_load));
					percore.add(new Op(OpCode.loadCONST, new Num(1), r_standard));
					percore.add(new Op(OpCode.computeEQUAL, r_standard, r_load, r_standard));
					percore.add(new Op(OpCode.branchABS, r_standard, new Num(( concurrentBlocksOps.size() * 10) + blockcodebefore ))); //TODO: The right number here
					percore.add(new Op(OpCode.loadCONST, new Num(-1), r_standard));
					percore.add(new Op(OpCode.computeEQUAL, r_standard, r_load, r_standard));
					percore.add(new Op(OpCode.branchABS, r_standard, new Num((totalprogsize)))); //TODO: The right number here
					blockcodebefore += concurrentBlocksOps.get(i).size();
				}
				percore.add(new Op(OpCode.jumpABS, new Num(0)));
				for (List<Op> ops: concurrentBlocksOps){
					percore.addAll(ops);
				}


			} else {
				percore.addAll(main.getOps());
				percore.add(new Op(OpCode.loadCONST, new Num(-1), r_standard));
				for (Set<OpListWrapper> corecor : map.values()) {
					for (OpListWrapper wrap : corecor) {
						if (wrap.equals(main)) {
							continue;
						}
						int address = wrap.getMemLocation();
						percore.add(new Op(OpCode.loadCONST, new Num(address), r_load));
						percore.add(new Op(OpCode.readINDA, r_load));
						percore.add(new Op(OpCode.receive, r_standard));
						percore.add(new Op(OpCode.computeNEQ, r_0, r_standard, r_standard ));
						percore.add(new Op(OpCode.branchREL, r_standard, new Num(-3)));
						percore.add(new Op(OpCode.loadCONST, new Num(-1), r_standard));
						percore.add(new Op(OpCode.writeINDA, r_standard, r_load));
					}
				}
				// Vijf extra instructies, anders is er de kans dat de write niet helemaal is uitgevoerd voordat het programma
				//getermineerd wordt. (Want de recieve duurt 5 instructies).
				percore.add(new Op(OpCode.nop));
				percore.add(new Op(OpCode.nop));
				percore.add(new Op(OpCode.nop));
				percore.add(new Op(OpCode.nop));
				percore.add(new Op(OpCode.nop));
			}



			for (int i = 0; i<percore.size(); i++) {
				if (i == 0) {
					sproclCode.append(" " + convertToSprocl(percore.get(i)));
				} else {
					sproclCode.append("\n" + s8 + ", " + convertToSprocl(percore.get(i)));
				}
			}
			sproclCode.append("\n" + s8 + ", EndProg");
			sproclCode.append("\n" + s8 + "]");
		}



        return sproclCode.toString();
    }

	public static String assemble(Program program, String progname){
		StringBuilder sproclCode = new StringBuilder();
		sproclCode.append("module "+progname+" where\n" +
				"\n" +
				"import BasicFunctions\n" +
				"import HardwareTypes\n" +
				"import Sprockell\n" +
				"import System\n" +
				"import Simulation\n" +
				"\n" +
                "main :: IO()\n" +
				"main = sysTest [prog]\n" +
				"\n" +
				"prog :: [Instruction]\n" +
				"prog = [");
		for(Instr instr: program.getInstr()) {
			sproclCode.append("\n" + s8);
			if (instr.getLine() != 0) {
				sproclCode.append(", ");
			}
			sproclCode.append(convertToSprocl((Op) instr));
		}
		if (program.getInstr().size()>0) {
			sproclCode.append("\n" + s8 + ", EndProg");
		} else {
			sproclCode.append("\n" + s8 + "EndProg");
		}
		sproclCode.append("\n" + s8 + "]");
		return sproclCode.toString();
	}


	private static String convertToSprocl(Op operation){
		OpCode opCode = operation.getOpCode();
		List<String> args = new ArrayList<>();
		for (Operand arg: operation.getArgs()){
			args.add(arg.toString());
		}
		String sproclCode;
		switch (opCode){

			//All the compute operations
			case computeADD:
				sproclCode = ("Compute Add " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeSUB:
				sproclCode = ("Compute Sub " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeMUL:
				sproclCode = ("Compute Mul " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeEQUAL:
				sproclCode = ("Compute Equal " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeNEQ:
				sproclCode = ("Compute NEq " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeGT:
				sproclCode = ("Compute Gt " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeGTE:
				sproclCode = ("Compute GtE " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeLT:
				sproclCode = ("Compute Lt " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeLTE:
				sproclCode = ("Compute LtE " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeAND:
				sproclCode = ("Compute And " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeOR:
				sproclCode = ("Compute Or " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			//TODO: The bitshifts
			case computeXOR:
				sproclCode = ("Compute Xor " + args.get(0) + " " + args.get(1) + " " + args.get(2));
				break;
			case computeRSHIFT:
				sproclCode = "Compute RShift " + args.get(0) + " " + args.get(1) + " " + args.get(2);
				break;


			//All the load operations
			case loadCONST:
				sproclCode = ("Load " + "(ImmValue (" + args.get(0)+ ")) " + args.get(1));
				break;
			case loadDIRA:
				sproclCode = ("Load " + "(DirAddr " + args.get(0)+ ") " + args.get(1));
				break;
			case loadINDA:
				sproclCode = ("Load " + "(IndAddr " + args.get(0)+ ") " + args.get(1));
				break;


			//All the store operations
			case storeCONST:
				sproclCode = ("Store " + args.get(0) + " (ImmValue "+ args.get(1) + ")");
				break;
			case storeDIRA:
				sproclCode = ("Store " + args.get(0) + " (DirAddr "+ args.get(1) + ")");
				break;
			case storeINDA:
				sproclCode = ("Store " + args.get(0) + " (IndAddr "+ args.get(1) + ")");
				break;
			case writeINDA:
				sproclCode = ("WriteInstr (" + args.get(0) + ") (IndAddr " + args.get(1) + ")");
				break;
			case writeDIRA:
				sproclCode = ("WriteInstr (" + args.get(0) + ") (DirAddr " + args.get(1) + ")");
				break;
			case readDIRA:
				sproclCode = ("ReadInstr (DirAddr " + args.get(0) + ")");
				break;
			case readINDA:
				sproclCode = ("ReadInstr (IndAddr " + args.get(0) + ")");
				break;
			case receive:
				sproclCode = ("Receive " + args.get(0));
				break;

			//All the branch statements
			case branchABS:
				sproclCode = ("Branch " + args.get(0) + " (Abs " + args.get(1)+ ")");
				break;
			case branchREL:
				sproclCode = ("Branch " + args.get(0) + " (Rel (" + args.get(1)+ "))");
				break;
			case branchIND:
				sproclCode = ("Branch " + args.get(0) + " (Ind " + args.get(1)+ ")");
				break;
			case jumpREL:
				sproclCode = ("Jump (Rel (" + args.get(0)+ "))");
				break;
			case jumpABS:
				sproclCode = ("Jump (Abs (" + args.get(0)+ "))");
				break;

			//All the stack operations
			case push:
				sproclCode = ("Push " + args.get(0));
				break;
			case pop:
				sproclCode = ("Pop " + args.get(0));
				break;

			case nop:
				sproclCode = "Nop";
				break;

			default:
				throw new UnsupportedOperationException(operation.toString());
		}
		return sproclCode;
	}
}
