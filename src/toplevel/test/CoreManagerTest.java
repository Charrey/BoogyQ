package toplevel.test;

import org.junit.Test;
import sprocl.model.Op;
import sprocl.model.OpCode;
import sprocl.model.Reg;
import toplevel.CoreManager;
import toplevel.OpListWrapper;
import toplevel.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 28-6-2016.
 */
public class CoreManagerTest {

    @Test
    public void testWithTree() {
        Op testop0 = new Op(OpCode.push, new Reg("0"));
        Op testop1 = new Op(OpCode.push, new Reg("1"));
        Op testop2 = new Op(OpCode.push, new Reg("2"));
        Op testop3 = new Op(OpCode.push, new Reg("3"));
        Op testop4 = new Op(OpCode.push, new Reg("4"));
        Op testop5 = new Op(OpCode.push, new Reg("5"));
        List<Op> listop0 = new LinkedList<>();
        listop0.add(testop0);
        List<Op> listop1 = new LinkedList<>();
        listop1.add(testop1);
        List<Op> listop2 = new LinkedList<>();
        listop2.add(testop2);
        List<Op> listop3 = new LinkedList<>();
        listop3.add(testop3);
        List<Op> listop4 = new LinkedList<>();
        listop4.add(testop4);
        List<Op> listop5 = new LinkedList<>();
        listop5.add(testop5);
        Tree<List<Op>> the_tree = new Tree<>(listop0);
        the_tree.addChild(listop1);
        the_tree.addChild(listop2);
        the_tree.addChild(listop3);
        the_tree.getChild(0).addChild(listop4);
        the_tree.getChild(0).addChild(listop5);
        //Tree<OpListWrapper> wrapped = CoreManager.instance.wrap(the_tree);
        //Map<OpListWrapper, Integer> assigned = CoreManager.instance.assignCores(wrapped);
        //System.out.println(assigned.get(wrapped.get()));
    }
}
