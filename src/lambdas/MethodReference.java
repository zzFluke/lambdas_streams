package lambdas;


import java.net.URL;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static utils.ColorConsolePrinter.printTitle;

public class MethodReference
{

//  0. Constructor reference Supplier<T>
    private static URL createURL(String url, ConstructorWithArgumentAndExceptions<String, URL> urlFactory) throws Exception
    {
        System.out.println("ConstructorWithArgumentAndExceptions<T,U>");
        return urlFactory.construct(url);
    }

//    private static URL createURL(String url, Function<String, URL> urlFactory) throws Exception
//    {
//        System.out.println("Function<T, U>");
//        return urlFactory.apply(url);
//    }


//  1. Array Constructor reference Function<Integer,T[]>
    private static <T> T[] createArray(Integer length, Function<Integer, T[]> arrayFactory)
    {
        T[] newArray = arrayFactory.apply(length);
        System.out.println("New Array created" +
                           "\nType: " + newArray.getClass().getComponentType() +
                           "\nLength: " + newArray.length);
        return newArray;
    }


//  2.  Static methods reference
    private static int consumeStatic(String str, Function<String, Integer> intParser)
    {
        int newInt = intParser.apply(str);
        System.out.println(newInt);
        return newInt;
    }


//  3.  Instance method reference
    public static void main(String[] args) throws Exception
    {
        // Constructor reference
        printTitle("Constructor reference");
        createURL("http://localhost", URL::new);

        // Array Constructor reference
        createArray(12, Object[]::new);


        // Static methods reference
        consumeStatic("100", Integer::valueOf);

    }

    interface ConstructorWithArgumentAndExceptions<T, U>
    {
        U construct(T arg) throws Exception;
    }
}
