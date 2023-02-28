package com.company.hw3;

import com.company.helper.ScannerHelper;

import java.util.ArrayList;

public class ThreeHW {
    public static void menuHR(ArrayList<HR> hr, ArrayList<Candidate> candidates){
        boolean itContinues = true;
        int choose = chooseHR(hr);
        while (itContinues) {
            System.out.println("\n\t1. Написать письмо \n\t2. Узнать данные кандидата \n\t6. Назад \n\t0. Выход");
            switch (ScannerHelper.getIntFromInput("Что нужно сделать? ")) {
                case 1:
                    hr.get(choose).sendEmail(ScannerHelper.getIntFromString("Введите email получателя: "));
                    break;
                case 2:
                    numberCandidate(candidates);
                    break;
                case 6:
                    MenuHW3.taskMenuSeminar3();
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

    private static int chooseHR(ArrayList<HR> hr){
        for (int i = 0; i < hr.size(); i++) {
            System.out.println((i + 1) + ". " + hr.get(i).getLastName() + " " + hr.get(i).getName());
        }
        int chooseHR = ScannerHelper.getIntFromInput("\nВыберите ваш профиль HR: ");
        System.out.println("Добро пожаловать в ЛК HR. Ваши данные:" + hr.get(chooseHR - 1).toString());
        return chooseHR;
    }

    private static void numberCandidate(ArrayList<Candidate> candidates){
        System.out.println("\nНаши кандидаты: ");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + " " + candidates.get(i).getLastName() + " " + candidates.get(i).getName());
        }
        int chooseCandidate = ScannerHelper.getIntFromInput("Выберите кандидата: ");
        System.out.println("Данные кандидата: " + candidates.get(chooseCandidate - 1).toString());
    }

    public static void menuManager(ArrayList<Manager> managers, ArrayList<HR> hr, ArrayList<Programist> programists) {
        boolean itContinues = true;
        entryManager(managers);
        while (itContinues) {
            System.out.println("\n\t1. Уволить \n\t2. Повысить зарплату сотруднику " +
                    "\n\t3. Перевести программиста на другой проект \n\t4. Написать письмо \n\t6. Назад \n\t0. Выход");
            switch (ScannerHelper.getIntFromInput("Что нужно сделать? ")) {
                case 1:
                    quitEmployee(managers, programists, hr);
                    break;
                case 2:
                    upSalary(managers, programists, hr);
                    break;
                case 3:
                    changeProject(managers, programists);
                    break;
                case 4:
                    managers.get(0).sendEmail(ScannerHelper.getIntFromString("Введите email получателя: "));
                    break;
                case 6:
                    MenuHW3.taskMenuSeminar3();
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

    private static void entryManager(ArrayList<Manager> managers){
        System.out.println("Добро пожаловать в ЛК руководителя. Ваши данные:" + managers.toString());

    }

    private static void quitEmployee(ArrayList<Manager> managers, ArrayList<Programist> programists, ArrayList<HR> hr) {
        int num = ScannerHelper.getIntFromInput("1 - HR; 2 - Программисты\nИз какого отдела нужно уволить сотрудника: ");
        if (num == 1) {
            for (int i = 0; i < hr.size(); i++) {
                System.out.print((i + 1) + ". " + hr.get(i).getLastName() + " " + hr.get(i).getName() + " "
                        + hr.get(i).isStatus() + "; ");
            }
            int quit = ScannerHelper.getIntFromInput("\nКакого сотрудника уволить: ");
            if (hr.get(quit - 1).isStatus()) {
                managers.get(0).quitHR(hr.get(quit - 1));
                System.out.println("Сотрудник " + hr.get(quit - 1).getLastName() + " " + hr.get(quit - 1).getName()
                        + " - уволен!; ");
            } else {
                System.out.println("Сотрудник уже давно уволен!!!Будьте внимательны!!!");
            }
        } else if (num == 2) {
            for (int i = 0; i < programists.size(); i++) {
                System.out.print((i + 1) + ". " + programists.get(i).getLastName() + " " + programists.get(i).getName()
                        + " " + programists.get(i).isStatus() + "; ");
            }
            int quit = ScannerHelper.getIntFromInput("\nКакого сотрудника уволить: ");
            if (programists.get(quit - 1).isStatus()) {
                managers.get(0).quitProgrammist(programists.get(quit - 1));
                System.out.println("Сотрудник " + programists.get(quit - 1).getLastName() + " "
                        + programists.get(quit - 1).getName() + " - уволен!; ");
            } else {
                System.out.println("Сотрудник уже давно уволен!!!Будьте внимательны!!!");
            }
        } else {
            System.out.println("Такого отдела нет!!!");
        }
    }

    private static void upSalary(ArrayList<Manager> managers, ArrayList<Programist> programists, ArrayList<HR> hr) {
        int num = ScannerHelper.getIntFromInput("1 - HR; 2 - Программисты\nВ каком отделе работает сотрудник: ");
        if (num == 1) {
            for (int i = 0; i < hr.size(); i++) {

                System.out.print((i + 1) + ". " + hr.get(i).getLastName() + " " + hr.get(i).getName() + "; ");
            }
            int id = ScannerHelper.getIntFromInput("\nКакому сотруднику повысить зарплату: ");
            if (hr.get(id - 1).isStatus()) {
                int ratio = ScannerHelper.getIntFromInput("На сколько увеличить зарплату: ");
                managers.get(0).upSalaryHR(ratio, hr.get(id - 1));
                System.out.println("Сотрудник " + hr.get(id - 1).getLastName() + " " + hr.get(id - 1).getSalary());
            } else {
                System.out.println("Сотрудник уже давно уволен!!!Будьте внимательны!!!");
            }
        } else if (num == 2) {
            for (int i = 0; i < programists.size(); i++) {
                System.out.print((i + 1) + ". " + programists.get(i).getLastName() + " " + programists.get(i).getName() + "; ");
            }
            int id = ScannerHelper.getIntFromInput("\nКакому сотруднику повысить зарплату: ");
            if (programists.get(id - 1).isStatus()) {
                int ratio = ScannerHelper.getIntFromInput("На сколько увеличить зарплату: ");
                managers.get(0).upSalaryProgrammist(ratio, programists.get(id - 1));
                System.out.println("Сотрудник " + programists.get(id - 1).getLastName() + " " + programists.get(id - 1).getSalary());
            } else {
                System.out.println("Сотрудник уже давно уволен!!!Будьте внимательны!!!");
            }
        } else {
            System.out.println("Такого отдела нет!!!");
        }
    }

    private static void changeProject(ArrayList<Manager> managers, ArrayList<Programist> programists){
        for (int i = 0; i < programists.size(); i++) {
            System.out.print((i + 1) + ". " + programists.get(i).getLastName() + " " + programists.get(i).getName()
                    + ": " +  programists.get(i).getDepartment() + "; ");
        }
        int id = ScannerHelper.getIntFromInput("\nКакого программиста перевести на другой проект: ");
        if (programists.get(id - 1).isStatus()) {
            String project = ScannerHelper.getIntFromString("Название проекта: ");
            managers.get(0).changeProject(programists.get(id - 1), project);
            System.out.println("Сотрудник " + programists.get(id - 1).getLastName() + " теперь работает на проекте:"
                    + programists.get(id - 1).getDepartment());
        }
    }


}
