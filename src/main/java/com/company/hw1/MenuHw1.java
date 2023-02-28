package com.company.hw1;

import com.company.Menu;
import com.company.helper.ScannerHelper;

public class MenuHw1 {
    private static final String TASK_MENU = "\nВыберите нужный пункт меню: "
            + "\n\t1 - Посмотреть весь автопарк"
            + "\n\t2 - Посмотреть гонку"
            + "\n\t3 - Передвижение грузовых машин"
            + "\n\t5 - Вернуться назад, в главное меню"
            + "\n\t0 - Выход";

    public static void taskMenuSeminar1(){
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(TASK_MENU);
            switch (ScannerHelper.getIntFromInput("Выберите задачу: ")) {
                case 1:
                    OneHW.viewAllCars();
                    break;
                case 2:
                    System.out.println(OneHW.race());
                    break;
                case 3:
                    OneHW.movingTrucks();
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
