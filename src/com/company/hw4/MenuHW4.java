package com.company.hw4;

import com.company.Menu;
import com.company.helper.ScannerHelper;

public class MenuHW4 {
    private static final String TASK_MENU = "\nВыберите нужный пункт меню: "
            + "\n\t1 - Посмотреть список всех задач"
            + "\n\t2 - Посмотреть список выполненных задач"
            + "\n\t3 - Посмотреть список не выполненных задач"
            + "\n\t4 - Отметить задачу как выполненную"
            + "\n\t5 - Создать задачу"
            + "\n\t6 - Изменить задачу"
            + "\n\t7 - Удалить задачу"
            + "\n\t9 - Вернуться назад, в главное меню"
            + "\n\t0 - Выход";

    public static void taskMenuSeminar4(){
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(TASK_MENU);
            switch (ScannerHelper.getIntFromInput("Выберите необходимое: ")) {
                case 1:
                    FourHW.showAllTasks();
                    break;
                case 2:
                    FourHW.showCompletedTTask();
                    break;
                case 3:
                    FourHW.showOutstandingTask();
                    break;
                case 4:
                    FourHW.changeStatusTask();
                    break;
                case 5:
                    FourHW.addNewTask();
                    break;
                case 6:
                    FourHW.changeTask();
                    break;
                case 7:
                    FourHW.deleteTask();
                    break;
                case 9:
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
