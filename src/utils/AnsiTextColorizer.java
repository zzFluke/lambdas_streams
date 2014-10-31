package utils;

import static utils.AnsiTextColorizer.Color.*;

public class AnsiTextColorizer
{
//    ANSI escape color codes
    enum Color
    {
        BLACK(30),
        RED(31),
        GREEN(32),
        YELLOW(33),
        BLUE(34),
        MAGENTA(35),
        CYAN(36),
        WHITE(37);

        private final int code;

        Color(int code)
        {
            this.code = code;
        }

    }

    public static String inGreen(String str)
    {
        return inColor(str, GREEN);
    };

    public static String inRed(String str)
    {
        return inColor(str, RED);
    }

    private static String inColor(String str, Color clr)
    {
        return String.format("\033[%dm%s\033[0m", clr.code, str);
    }
}
