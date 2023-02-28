package com.company.hw3;

import com.company.Menu;
import com.company.helper.ScannerHelper;

import java.util.ArrayList;


public class MenuHW3 {
    private static final String TASK_MENU = "\nВыберите нужный пункт меню: "
            + "\n\t1 - ЛК Руководитель"
            + "\n\t2 - ЛК HR"
            + "\n\t5 - Вернуться назад, в главное меню"
            + "\n\t0 - Выход";

    public static void taskMenuSeminar3(){
        ArrayList<Manager> managers = InitialPeople.initManager();
        ArrayList<HR> hr = InitialPeople.initHR();
        ArrayList<Programist> programists = InitialPeople.initProgramist();
        ArrayList<Candidate> candidates = InitialPeople.initCandidate();
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(TASK_MENU);
            switch (ScannerHelper.getIntFromInput("Выберите права: ")) {
                case 1:
                    ThreeHW.menuManager(managers, hr, programists);
                    break;
                case 2:
                    ThreeHW.menuHR(hr, candidates);
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
