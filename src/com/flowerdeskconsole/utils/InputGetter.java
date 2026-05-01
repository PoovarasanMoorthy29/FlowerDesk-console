package com.flowerdeskconsole.utils;
import java.util.Scanner;
public class InputGetter {
    private static final Scanner SCANNER=new Scanner(System.in);
    public static Scanner getInstance(){
        return SCANNER;
    }
}
