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

	public static String assemble(Program program, String filename){
		StringBuilder sproclCode = new StringBuilder();
		sproclCode.append("module "+filename+" where\n" +
				"\n" +
				"import BasicFunctions\n" +
				"import HardwareTypes\n" +
				"import Sprockell\n" +
				"import System\n" +
				"import Simulation\n" +
				"prog :: [Instruction]\n" +
				"prog = [");
		for(Instr instr: program.getInstr()) {
			System.out.println(instr.toString());
			Op operation = (Op) instr;
			OpCode opCode = operation.getOpCode();
			List<String> args = new ArrayList<>();
			for (Operand arg: operation.getArgs()){
				args.add(arg.toString());
			}
			sproclCode.append("\n\t\t");
			switch (opCode){
				//All the compute operations
				case computeADD:
					sproclCode.append("Compute Add " + args.get(0) + " " + args.get(1) + " " + args.get(2));
					break;

				//All the load operations
				case loadCONST:
					sproclCode.append("Load " + "NUM(" + args.get(0)+ ") " + args.get(1));
					break;

				//All the store operations
				case storeDIRA:
					sproclCode.append("Store " + args.get(0) + " (DirAddr "+ args.get(1) + ")");
					break;

				//All the stack operations
				case push:
					sproclCode.append("Push " + args.get(0));
					break;
				case pop:
					sproclCode.append("Pop " + args.get(0));
					break;

				default:
					sproclCode.append("???TBD???"); //TODO: Throw an error.
					break;
			}
		}
		sproclCode.append("\n]");
		return sproclCode.toString();
	}
}
