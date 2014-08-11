package lambdas;

import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;


public class TypeInference
{

    Predicate<Integer> atLeast5 = x -> x > 5;
    BinaryOperator<Long> addLongs = (x, y) -> x + y;


//    BinaryOperator add = (x, y) -> x + y;      //    Missing generic


//    Overloading

//    Case 1 inheritance
    private interface IntegerBiFunction extends BinaryOperator<Integer> {
    }

    private static void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.print("BinaryOperator");
    }
    private static void overloadedMethod(IntegerBiFunction lambda) {
        System.out.print("IntegerBinaryOperator");
    }

//    Case 2 no inheritance
    private interface IntPredicate {
        public boolean test(int value);
    }
    private static void overloadedMethod(Predicate<Integer> predicate) {
        System.out.print("Predicate");
    }
    private static void overloadedMethod(IntPredicate predicate) {
        System.out.print("IntPredicate");
    }


//    Case 3 Runnable | Callable
    private static void runnableOrCallable(Runnable r)
    {
        System.out.println("Runnable");
        r.run();
    }

    private static void runnableOrCallable(Callable c)
    {
        try
        {
            System.out.println("Callable");
            c.call();
        }
        catch (Exception e)
        {
            // NO-OP
        }
    }

    public static void main(String[] args)
    {

//        Case 1
        overloadedMethod((x, y) -> x + y);

//        Case 2
//        overloadedMethod((x) -> true); // Ambiguous method call

//        Case 3
        runnableOrCallable(() -> "test");
    }
}
