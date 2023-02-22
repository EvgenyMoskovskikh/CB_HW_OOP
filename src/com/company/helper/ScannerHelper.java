package com.company.helper;

import java.util.*;

public class ScannerHelper {
    private final static Scanner READER = new Scanner(System.in);
    private final static Random RANDOM = new Random();

    public static int getIntFromInput(String text) {
        boolean ifInputError = true;
        int number = 0;
        System.out.print(text);
        while (ifInputError) {
            if (READER.hasNextInt()) {
                number = READER.nextInt();
                ifInputError = false;
            }
            else {
                System.out.print("ОШИБКА! " + text);
                READER.next();
            }
        }
        return number;
    }

    public static double getIntFromDouble(String text) {
        boolean ifInputError = true;
        double number = 0;
        System.out.print(text);
        while (ifInputError) {
            if (READER.hasNextDouble()) {
                number = READER.nextDouble();
                ifInputError = false;
            }
            else {
                System.out.print("ОШИБКА! " + text);
                READER.next();
            }
        }
        return number;
    }

    public static String getIntFromString(String text) {
        boolean ifInputError = true;
        String str = "";
        System.out.print(text);
        while (ifInputError) {
            if (READER.hasNext()) {
                str = READER.next();
                ifInputError = false;
            }
            else {
                System.out.print("ОШИБКА! " + text);
                READER.next();
            }
        }
        return str;
    }

    public static void close() {
        READER.close();
    }

    public static int numRandom(int start, int end) {
        int num = RANDOM.nextInt((end -start) + 1) + start;
        return num;
    }

}
