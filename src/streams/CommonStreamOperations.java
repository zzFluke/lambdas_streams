package streams;

import static utils.ColorConsolePrinter.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CommonStreamOperations
{
    private static void flatMap0()
    {

        printTitle("Parse MultiMap with flatMap()");
        
        Map<String, List<String>> multiMap = new HashMap<String, List<String>>()
        {
            {
                put("Knuth", asList("The Art of Programming", "Math"));
                put("Bloch", asList("Effective Java", "Java Puzzlers"));
            }
        };

        Set<String> allBooks = multiMap.values().stream()
            .flatMap(books -> books.stream().map(String::toUpperCase))
            .collect(toSet());
        System.out.println(allBooks);
    }
    
    private static void flatMap1()
    {
        printTitle("Display files in current dir and one level down using flatMap");
        Stream.of( new File("."))
            .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
            .forEach(file -> System.out.println(file.getName()));
    }
    
    
    public static void main(String[] args)
    {
        // Parse multiMap with flatMap()
        flatMap0();
        
        // Display files in current dir and one level down
        flatMap1();
        
    }
    

}
