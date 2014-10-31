package utils;

import static utils.AnsiTextColorizer.inGreen;

public class ColorConsolePrinter
{
    public static void printTitle(String title)
    {
        System.out.println(inGreen(String.format("\n########## %s ###########\n", title)));
    }
    


}
