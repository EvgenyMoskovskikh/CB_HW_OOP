package com.company.hw2;

import com.company.Menu;
import com.company.helper.ScannerHelper;

public class MenuHw2 {
    private static final String TASK_MENU = "\nВыберите нужный пункт меню: "
            + "\n\t1 - Посмотреть все продукты"
            + "\n\t2 - Купить продукт"
            + "\n\t3 - АДМИН.Добавить товары"
            + "\n\t5 - Вернуться назад, в главное меню"
            + "\n\t0 - Выход";

    public static void taskMenuSeminar2(){
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(TASK_MENU);
            switch (ScannerHelper.getIntFromInput("Выберите задачу: ")) {
                case 1:
                    TwoHW.viewAllProducts();
                    break;
                case 2:
                    TwoHW.buyProducts();
                    break;
                case 3:
                    TwoHW.addProducts();
                    break;
                case 5:
                    Menu.startMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Такого действия не существует!");
                    break;
            }
        }
        ScannerHelper.close();
    }
}
