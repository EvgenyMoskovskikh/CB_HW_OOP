package com.company.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScannerHelper {
    private final static Scanner READER = new Scanner(System.in);
    private final static Random RANDOM = new Random();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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

    public static double getDoubleFromInput(String text) {
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

    public static boolean isYes(String text) {
        System.out.print(text);
        String answer = READER.next().toLowerCase().trim().replaceAll("\\p{P}", "");
        return "y".equals(answer) || "yes".equals(answer) || "да".equals(answer);
    }

    public static double readDouble(){
        try{
            return Double.parseDouble(readString());
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readDouble();
        }
    }

    public static String readString(){
        try{
            return bufferedReader.readLine();
        }
        catch (IOException e){
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
    }

    public static int readInt(int min, int max){
        try{
            int readInt = getIntFromInput("считываю число? ");
            if (readInt>min && readInt<max) return readInt;
            else {
                System.out.println("Введенное значение должно быть в диапазоне от " + min + " до " + max);
                return readInt(min, max);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return  readInt(min, max);
        }
    }

    public static double readDouble(int min){
        try{
            double readDouble =readDouble();
            if (readDouble>(double) min) return readDouble;
            else {
                System.out.println("Введенное значение должно быть больше " + min);
                return readDouble(min);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readDouble(min);
        }
    }



}
