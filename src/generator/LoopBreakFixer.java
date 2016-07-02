package generator;

import sprocl.model.Num;
import sprocl.model.Op;
import sprocl.model.OpCode;

import java.util.List;

/**
 * Class responsible for changing the arrow-notation of loop and break statements to Parse-friendly syntax.
 */
class LoopBreakFixer {


    /**
     * Rewrites any jumpBREAK and jumpLABEL to correct equivalents.
     * @param input Unfixed list of operations.
     * @return Fixed list of operations.
     */
    static List<Op> fix(List<Op> input) {
        return fixBreak(fixLoop(input));
    }

    /**
     * Rewrites any jumpBREAK to correct equivalents.
     * @param input Unfixed list of operations
     * @return Fixed list of operations.
     */
    private static List<Op> fixBreak(List<Op> input) {
        for (int i = 0; i<input.size(); i++) {
            if (!input.get(i).getOpCode().equals(OpCode.jumpBREAK)) {
                continue;
            }
            int tojumpto = ((Num) input.get(i).getArgs().get(0)).getValue();
            for (int p = 0; p<input.size(); p++) {
                if (input.get(p).getIfEndLabels().contains(String.valueOf(tojumpto))) {
                    input.get(i).setOpCode(OpCode.jumpREL);
                    input.get(i).setArg(0, new Num(p-i + 1));
                    break;
                }
            }
        }
        return input;
    }


    /**
     * Rewrites any jumpLABEL to correct equivalents.
     * @param input Unfixed list of operations
     * @return Fixed list of operations.
     */
    private static List<Op> fixLoop(List<Op> input) {
        for (int i = 0; i<input.size(); i++) {
            if (!input.get(i).getOpCode().equals(OpCode.jumpLABEL)) {
                continue;
            }
            int tojumpto = ((Num) input.get(i).getArgs().get(0)).getValue();
            for (int p = 0; p<input.size(); p++) {
                if (input.get(p).getIfStartLabel().equals(String.valueOf(tojumpto))) {
                    input.get(i).setOpCode(OpCode.jumpREL);
                    input.get(i).setArg(0, new Num(p-i));
                    break;
                }
            }
        }
        return input;
    }
}
