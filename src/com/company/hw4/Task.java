package com.company.hw4;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String topic;
    private User author;
    private String text;
    private Priority priority;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private boolean status;

    public Task(String topic, User author, String text, Priority priority, LocalDateTime dateStart, LocalDateTime dateEnd) {
        this.topic = topic;
        this.author = author;
        this.text = text;
        this.priority = priority;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = false;

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String statusName(){
        if(this.status){
            return "выполнено";
        }
        return "не выполнено";
    }

    @Override
    public String toString() {
        return  "\n\tТема: " + topic +
                "\n\t" + author +
                "\n\tЗадача: " + text +
                "\n\tПриоритет: " + priority +
                "\n\tДата начала: " + dateStart +
                "\n\tДата завершения: " + dateEnd +
                "\n\tСтатус: " + statusName();
    }
}
