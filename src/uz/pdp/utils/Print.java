package uz.pdp.utils;

import static uz.pdp.utils.Color.*;

public class Print {
    public static void print(Object obj) {
        print(PURPLE, obj);
    }

    public static void print(String color, Object obj) {
        System.out.print(color + obj + RESET);
    }

//    public static void println(Object obj) {
//        println(PURPLE, obj);
//    }

    public static void println(String color, Object obj) {
        System.out.println(color + obj + RESET);
    }

    public static void warning(String str) {
        println(RED, str);
    }

    public static void print(String str) {
        System.out.print(str);
    }
    public static void println(String str) {
        System.out.println(str);
    }
}
