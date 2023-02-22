package com.company.hw4;

import java.io.Serializable;
import java.util.ArrayList;

public class Calendar implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Task> tasks;

    public Calendar() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void showAllTask() {
        int i = 1;
        for (Task task : tasks) {
            System.out.println("\n\t№ " + i + " " + task);
            i++;
        }
    }

    public void showOutsideTask() {
        int i = 1;
        for (Task task : tasks) {
            if (!task.isStatus()) {
                System.out.println("\n\t№ " + i + " " + task);
                i++;
            }
        }
    }

    public void showCompletedTasks(){
        int i = 1;
        for (Task task : tasks) {
            if (task.isStatus()) {
                System.out.println("\n\t№ " + i + " " + task);
                i++;
            }
        }
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(Task task){
        this.tasks.remove(task);
    }

    public void changeTopicTask(Task task, String topic){
        task.setTopic(topic);
    }

    public void changeTextTask(Task task, String text){
        task.setText(text);
    }

    public void changeStatus(Task task) {
        if (task.isStatus()) {
            System.out.println("Задача уже выполнена");
        } else {
            task.setStatus(true);
        }
    }
}
