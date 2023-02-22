package com.company.hw4;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calendar<T extends Task> implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<T> tasks;

    public Calendar() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<T> getTasks() {
        return tasks;
    }

    public void showAllTask() {
        int i = 1;
        for (T task : tasks) {
            System.out.println("\n\t№ " + i + " " + task);
            i++;
        }
    }

    public void showOutsideTask() {
        int i = 1;
        for (T task : tasks) {
            if (!task.isStatus()) {
                System.out.println("\n\t№ " + i + " " + task);
                i++;
            }
        }
    }

    public void showCompletedTasks(){
        int i = 1;
        for (T task : tasks) {
            if (task.isStatus()) {
                System.out.println("\n\t№ " + i + " " + task);
                i++;
            }
        }
    }

    public void addTask(T task) {
        this.tasks.add(task);
    }

    public void deleteTask(T task){
        this.tasks.remove(task);
    }

    public void changeTopicTask(T task, String topic){
        task.setTopic(topic);
    }

    public void changeTextTask(T task, String text){
        task.setText(text);
    }

    public void changePriority(T task, Priority priority){
        task.setPriority(priority);
    }

    public void changeDateStart(T task, LocalDateTime dateTime){
        task.setDateStart(dateTime);
    }

    public void changeDateEnd(T task, LocalDateTime dateTime){
        task.setDateEnd(dateTime);
    }

    public void changeStatus(T task) {
        if (task.isStatus()) {
            System.out.println("Задача уже выполнена");
        } else {
            task.setStatus(true);
        }
    }
}
