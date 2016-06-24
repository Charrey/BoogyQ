package sprocl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import sprocl.model.*;


/** Assembler for the ILOC language. */
public class Assembler {

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
			sproclCode.append("\n\t\t");
			if (instr.getLine() != 0) {
				sproclCode.append(", ");
			}
			sproclCode.append(convertToSprocl((Op) instr));
		}
		sproclCode.append("\n\t\t]");
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
				sproclCode = ("Compute Sub " + args.get(0) + " " + args.get(1) + " " + args.get(2));
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
			//All the load operations
			case loadCONST:
				sproclCode = ("Load " + "(ImmValue " + args.get(0)+ ") " + args.get(1));
				break;

			//All the store operations
			case storeDIRA:
				sproclCode = ("Store " + args.get(0) + " (DirAddr "+ args.get(1) + ")");
				break;

			//All the stack operations
			case push:
				sproclCode = ("Push " + args.get(0));
				break;
			case pop:
				sproclCode = ("Pop " + args.get(0));
				break;

			default:
				sproclCode = ("???TBD???"); //TODO: Throw an error.
				break;
		}
		return sproclCode;
	}
}
