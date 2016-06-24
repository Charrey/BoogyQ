package sprocl;

import java.util.ArrayList;
import java.util.List;

import sprocl.model.*;


/** Assembler for the ILOC language. */
public class Assembler {

	public static String s4 = "    "; 	//We need to use 4 spaces instead of a tab.
	public static String s8 = s4+s4;

	public static String assemble(Program program, String progname){
		StringBuilder sproclCode = new StringBuilder();
		sproclCode.append("module "+progname+" where\n" +
				"\n" +
				"import BasicFunctions\n" +
				"import HardwareTypes\n" +
				"import Sprockell\n" +
				"import System\n" +
				"import Simulation\n" +
				"prog :: [Instruction]\n" +
				"prog = [");
		for(Instr instr: program.getInstr()) {
			sproclCode.append("\n" + s8);
			if (instr.getLine() != 0) {
				sproclCode.append(", ");
			}
			sproclCode.append(convertToSprocl((Op) instr));
		}
		sproclCode.append("\n" + s8 + ", EndProg");
		sproclCode.append("\n" + s8 + "]");
		return sproclCode.toString();
	}


	public static String convertToSprocl(Op operation){
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


			//All the load operations
			case loadCONST:
				sproclCode = ("Load " + "(ImmValue " + args.get(0)+ ") " + args.get(1));
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


			//All the branch statements
			case branchABS:
				sproclCode = ("Branch " + args.get(0) + "(Abs " + args.get(1)+ ")");
				break;
			case branchREL:
				sproclCode = ("Branch " + args.get(0) + "(Rel " + args.get(1)+ ")");
				break;
			case branchIND:
				sproclCode = ("Branch " + args.get(0) + "(Ind " + args.get(1)+ ")");
				break;


			//All the stack operations
			case push:
				sproclCode = ("Push " + args.get(0));
				break;
			case pop:
				sproclCode = ("Pop " + args.get(0));
				break;


			default:
				throw new UnsupportedOperationException(operation.toString());
		}
		return sproclCode;
	}
}
