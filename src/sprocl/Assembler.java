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
				"import Simulation");
		for(Instr instr: program.getInstr()){
			System.out.println(instr.toString());
			Op operation = (Op) instr;
			OpCode opCode = operation.getOpCode();

			switch (opCode){
				case computeADD:

			}
		}
		return sproclCode.toString();
	}
}
