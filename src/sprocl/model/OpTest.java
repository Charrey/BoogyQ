package sprocl.model;


import org.junit.Test;

/**
 * Created by Hans on 21-6-2016.
 */
public class OpTest {

   @Test
   public void prettyPrintTest1(){
       Program program = new Program();
       program.addInstr(new Op(OpCode.loadCONST, new Num(1), new Reg("r1")));
       program.addInstr(new Op(OpCode.loadCONST, new Num(1), new Reg("r1")));
       program.addInstr(new Op(OpCode.loadCONST, new Num(1), new Reg("r1")));
       program.addInstr(new Op(OpCode.jumpABS, new Num(10)));
       System.out.println(program.prettyPrint());
   }
}
