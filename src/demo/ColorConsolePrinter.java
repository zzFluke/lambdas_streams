package demo;

public class ColorConsolePrinter
{
    public static void printTitle(String message)
    {
        System.out.println(String.format("\n########## %s ###########\n", inGreen(message)));
    }
    
    public static String inGreen(String str)
    {
        return String.format("\033[32m%s\033[0m", str);
    };
    
}
