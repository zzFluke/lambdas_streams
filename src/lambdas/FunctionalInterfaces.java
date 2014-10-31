package lambdas;

import java.util.Comparator;

public class FunctionalInterfaces
{
    public static void main(String[] args)
    {
        Comparator<String> comp = String.CASE_INSENSITIVE_ORDER;

        // With Inner Class
        StringCounter<String, Integer> counterInner = new StringCounter<String, Integer>() {
            @Override
            public Integer apply(String t) {
                return t.length();
            }
        };


        // With Lambda expression
        StringCounter<String, Integer> counterLambda = str -> str.length();
    }
}

@FunctionalInterface
interface StringCounter<String, U extends Number>
{
    U apply(String t);

//    U apply2(String t);

}
