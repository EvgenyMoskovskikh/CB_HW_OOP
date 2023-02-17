package com.company;

import com.company.helper.ScannerHelper;
import com.company.hw1.MenuHw1;
import com.company.hw2.MenuHw2;
import com.company.hw3.MenuHW3;

public class Menu {
    private static final String SELECT_ACTION = "Выберите действие: ";
    private static final String INCORRECT_INPUT = "Такого действия не существует!";
    private static final String MAIN_MENU = "\nВыберите нужный пункт меню: "
            + "\n\t1 - Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм"
            + "\n\t2 - Урок 2 Принципы ООП Абстракция и интерфейсы. Пример проектирования"
            + "\n\t3 - Урок 3 Некоторые стандартные интерфейсы Java и примеры их использования"
            + "\n\t4 - Урок 4 ООП: Обобщения. ч1"
            + "\n\t5 - Урок 5 От простого к практике"
            + "\n\t6 - Урок 6 ООП Дизайн и Solid"
            + "\n\t6 - Урок 7 ООП Дизайн и Solid ч.2"
            + "\n\t0 - Выход";


    public static void startMenu(){
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(MAIN_MENU);
            switch (ScannerHelper.getIntFromInput(SELECT_ACTION)) {
                case 1:
                    MenuHw1.taskMenuSeminar1();
                    break;
                case 2:
                    MenuHw2.taskMenuSeminar2();
                    break;
                case 3:
                    MenuHW3.taskMenuSeminar3();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Находится в разработке!");
                case 0:
                    System.exit(0);
                default:
                    System.out.println(INCORRECT_INPUT);
                    break;
            }
        }
        ScannerHelper.close();
    }
}
