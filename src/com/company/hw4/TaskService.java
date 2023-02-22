package com.company.hw4;

import java.io.Serializable;
import java.util.Date;

public class TaskService implements Serializable {
    private static final long serialVersionUID = 1L;

    private Calendar calendar;
    private static int id;

    public TaskService(Calendar calendar) {
        this.calendar = calendar;
    }

//    public void addTask(String topic, User author, String text, Priority priority, Date dateStart, Date dateEnd, Date deadline){
//        calendar.add(new Task(id++, topic, author, text, priority, dateStart,dateEnd, deadline));
//    }
}
