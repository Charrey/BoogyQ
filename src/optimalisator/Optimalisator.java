package optimalisator;

import sprocl.model.Num;
import sprocl.model.Op;
import sprocl.model.OpCode;

import java.util.List;

/**
 * Created by poesd_000 on 27/06/2016.
 */
public class Optimalisator {

    //TODO
    public static List<Op> PushPopFix(List<Op> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).getOpCode().equals(OpCode.push) && input.get(i+1).getOpCode().equals(OpCode.pop)) {
                if (input.get(i).getArgs().get(0).equals(new Num(0))) {
                    input.set(i, new Op(OpCode.nop));
                    input.set(i+1, new Op(OpCode.loadCONST, new Num(0), input.get(i+1).getArgs().get(1)));
                } else {


                    for (int p = i-1; p>=0; p--) {

                    }



                }
                i = 0;
            }

        }
        return null; //TODO
    }

}
