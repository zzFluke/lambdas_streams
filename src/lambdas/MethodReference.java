package lambdas;


import functional.YCombinator;

import java.net.URL;
import java.util.function.Function;

public class MethodReference
{

//  0. Constructor reference Supplier<T>
    private static URL createURL(String url, ConstructorWithArgumentAndExceptions<String, URL> urlFactory) throws Exception
    {
        System.out.println("ConstructorWithArgumentAndExceptions<T,U>");
        return urlFactory.construct(url);
    }

    private static URL createURL(String url, Function<String, URL> urlFactory) throws Exception
    {
        System.out.println("Function<T,U>");
        return urlFactory.apply(url);
    }


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


//  3.  Instance method reference

    public static void main(String[] args) throws Exception
    {

        createURL("http://test", (ConstructorWithArgumentAndExceptions<String, URL>)URL::new);

        createArray(12, YCombinator[]::new);

    }

    interface ConstructorWithArgumentAndExceptions<T, U>
    {
        U construct(T arg) throws Exception;
    }

}
