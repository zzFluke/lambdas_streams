package streams;

import static demo.ColorConsolePrinter.*;
import static java.util.Comparator.*;
import static java.util.Objects.*;
import static java.util.stream.Collectors.joining;

import java.util.*;
import java.util.stream.*;

public class Reduce
{
    
    private static void intMin()
    {
        printTitle("Stream.min() example");
        
        int[] arr = {1, 2, 24, 5, 5, 7, 8};
        int min = Arrays.stream(arr)
            .min()
            .getAsInt();
            
        System.out.println("Min value: " + min);
            
    }
    
    private static void maxWithComparator()
    {
        printTitle("Stream.max(Comparator<T>) example");
        
        String minLength = Stream.of("java", "c++", "haskel", "lisp", "delphi", "brainfuck", "python")
            .max(comparing(String::toLowerCase, (n0, n1) -> n0.length() - n1.length()))
            .get();
        
        System.out.println(minLength);
    }
    
    private static void percentileCollector()
    {
        printTitle("Stream custom percentile reducer");
        
        
        IntStream stream = new Random().ints(50, 1, 100);
        int percentile = 10;
        int percentileAt = collectToPercentile(stream.toArray(), percentile)
            .getAsInt();
        System.out.println(String.format("%d is the %dth percentile", percentileAt, percentile));
        
    }
    
    private static OptionalInt collectToPercentile(int[] arr, double percentile)
    {
        if (nonNull(arr) && percentile > 100 || percentile < 0) throw new IllegalArgumentException("Wrong percentile! Must be 1-100");

        int[] sortedArr = Arrays.copyOf(arr,arr.length);
        Arrays.parallelSort(sortedArr);

        int percentilePtr = (int)Math.round(arr.length * percentile / 100) - 1;

        String arrStr = Arrays.stream(sortedArr).mapToObj(i -> i == sortedArr[percentilePtr] ? inGreen(String.valueOf(i)) : String.valueOf(i)).collect(joining(","));
        System.out.println(arrStr);
        return OptionalInt.of(sortedArr[percentilePtr]);
    }
    
    
    public static void main(String[] args)
    {
        // Stream.min() demo
        intMin();

        // Stream.max() demo
        maxWithComparator();

        percentileCollector();
    }

}
