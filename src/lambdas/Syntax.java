package lambdas;

import java.util.function.BinaryOperator;

public class Syntax
{

    static BinaryOperator<Integer> sum = (Integer i0, Integer i1) ->
                            { System.out.println("Adding.."); return i0 + i1; };


    public static void main(String[] args) {

    }
}
