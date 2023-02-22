package com.company.hw4;

import com.company.helper.ScannerHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FourHW {
    private static final String path = "src/com/company/hw4/Tasks.txt";

    public static void startInitTask() {               //необходим при первом запуске программы!!!!Если нет файла
        Calendar calendar = new Calendar();
        User user = new User("Вася");

        calendar.addTask(new Task("Лекция 1 ООП", user, "первая лекция по ООП", Priority.important,
                LocalDateTime.of(2022, 2, 15, 18, 0),
                LocalDateTime.of(2022, 2, 15, 20, 0)));
        calendar.addTask(new Task("Семинар 1 ООП", user, "первый семинар по ООП", Priority.basic,
                LocalDateTime.of(2022, 2, 20, 14, 0),
                LocalDateTime.of(2022, 2, 20, 18, 0)));
        calendar.addTask(new Task("ДЗ", user, "сделать домашку", Priority.ordinary,
                LocalDateTime.of(2022, 2, 24, 18, 0),
                LocalDateTime.of(2022, 2, 24, 20, 0)));

        SaveToFile.saveToFile(calendar, path);
    }

    public static void showAllTasks() {
//        startInitTask();                            //необходим при первом запуске программы!!!!Если нет файла
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        calendar.showAllTask();
    }

    public static void changeStatusTask() {
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        calendar.showOutsideTask();
        int num = ScannerHelper.getIntFromInput("Выберите задачу, которую выполнили: ");
        calendar.changeStatus(calendar.getTasks().get(num - 1));
        SaveToFile.saveToFile(calendar, path);
        System.out.println("Задача \"" + calendar.getTasks().get(num - 1).getTopic() + "\" выполнена!");
    }

    public static void showOutstandingTask() {
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        calendar.showOutsideTask();
    }

    public static void showCompletedTTask() {
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        calendar.showCompletedTasks();
    }

    public static void addNewTask() {
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        Priority priority = changePriority();
        User user = new User("Вася");
        String topic = ScannerHelper.getIntFromString("Введите название задачи: ");
        String text = ScannerHelper.getIntFromString("Введите текст задачи: ");
        LocalDateTime start = createDate("Дата начала:");
        LocalDateTime end = createDate("Дата завершения:");
        if (start.isAfter(end)) {
            System.out.println("Извините, но дата завершения задачи, должна быть не раньше даты начала!!!\nЗадача не добавлена!!!");
            MenuHW4.taskMenuSeminar4();
        } else {
            for (int i = 0; i < calendar.getTasks().size(); i++) {
                if (calendar.getTasks().get(i).getDateStart().isBefore(start)
                        && calendar.getTasks().get(i).getDateEnd().isAfter(start) && !calendar.getTasks().get(i).isStatus()) {
                    System.out.println("\tВНИМАНИЕ!!!В этот период уже есть задача: " + calendar.getTasks().get(i).getTopic() +
                            "\n\tС приоритетом: " + calendar.getTasks().get(i).getPriority());
                }
            }
            calendar.addTask(new Task(topic, user, text, priority, start, end));
            SaveToFile.saveToFile(calendar, path);
        }
    }

    private static Priority changePriority() {
        int num = ScannerHelper.getIntFromInput("Выберите приоритет: \n\t1 - Важный\n\t2 - Основной\n\t3 - Обычный\n");
        if (num == 1) {
            return Priority.important;
        } else if (num == 2) {
            return Priority.basic;
        } else if (num == 3) {
            return Priority.ordinary;
        } else {
            System.out.println("Нет такого приоритета!!!");
        }
        return Priority.ordinary;
    }

    public static void deleteTask() {
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        showAllTasks();
        int num = ScannerHelper.getIntFromInput("Введите номер задачи, которую нужно удалить: ");
        calendar.deleteTask(calendar.getTasks().get(num - 1));
        System.out.println("Задача успешно удалена");
        SaveToFile.saveToFile(calendar, path);
    }

    public static void changeTask() {
        Calendar calendar = ReadFromFile.initializeFromFile(path);
        showAllTasks();
        int num = ScannerHelper.getIntFromInput("Выберите задачу, которую нужно изменить: ");
        String topic = ScannerHelper.getIntFromString("Введите новое название задачи: ");
        changeTopic(num - 1, calendar, topic);
        String text = ScannerHelper.getIntFromString("Введите новый текст задачи: ");
        changeText(num - 1, calendar, text);
        SaveToFile.saveToFile(calendar, path);
        showAllTasks();
    }

    private static void changeTopic(int num, Calendar calendar, String topic) {
        calendar.changeTopicTask(calendar.getTasks().get(num), topic);
    }

    private static void changeText(int num, Calendar calendar, String text) {
        calendar.changeTextTask(calendar.getTasks().get(num), text);
    }

    private static LocalDateTime createDate(String str) {
        System.out.println(str);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String day = ScannerHelper.getIntFromString("Введите дату (дд.мм.гггг): ");
        String time = ScannerHelper.getIntFromString("Введите время (чч:мм): ");
        String dataTime = day + " " + time;

        LocalDateTime dt = LocalDateTime.parse(dataTime, dateFormat);
        System.out.println(dateFormat.format(dt));
        return dt;
    }
}
