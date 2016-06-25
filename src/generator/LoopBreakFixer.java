package generator;

import sprocl.model.Num;
import sprocl.model.Op;
import sprocl.model.OpCode;

import java.util.List;

/**
 * Created by jij on 25/06/2016.
 */
public class LoopBreakFixer {


    public static List<Op> fix(List<Op> input) {
        return fixBreak(fixLoop(input));
    }

    public static List<Op> fixBreak(List<Op> input) {
        for (int i = 0; i<input.size(); i++) {
            if (!input.get(i).getOpCode().equals(OpCode.jumpBREAK)) {
                continue;
            }
            int tojumpto = ((Num) input.get(i).getArgs().get(0)).getValue();
            for (int p = 0; p<input.size(); p++) {
                if (input.get(p).getIfEndLabels().contains(String.valueOf(tojumpto))) {
                    input.get(i).setOpCode(OpCode.jumpIND);
                    input.get(i).setArg(0, new Num(p-i + 1));
                    break;
                }
            }
        }
        return input;
    }

    public static List<Op> fixLoop(List<Op> input) {
        for (int i = 0; i<input.size(); i++) {
            if (!input.get(i).getOpCode().equals(OpCode.jumpLABEL)) {
                continue;
            }
            int tojumpto = ((Num) input.get(i).getArgs().get(0)).getValue();
            for (int p = 0; p<input.size(); p++) {
                if (input.get(p).getIfStartLabel().equals(String.valueOf(tojumpto))) {
                    input.get(i).setOpCode(OpCode.jumpIND);
                    input.get(i).setArg(0, new Num(p-i));
                    break;
                }
            }
        }
        return input;
    }
}
