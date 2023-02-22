package com.company.hw4;

import java.time.LocalDateTime;

public class WorkTask extends Task{
    private User executor;
    public WorkTask(String topic, User author, String text, Priority priority, LocalDateTime dateStart,
                    LocalDateTime dateEnd, User executor) {
        super(topic, author, text, priority, dateStart, dateEnd);
        this.executor = executor;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    @Override
    public String toString() {
        return "\n\tТема: " + super.getTopic() +
                "\n\t" + super.getAuthor() +
                "\n\tЗадача: " + super.getText() +
                "\n\tПриоритет: " + super.getPriority() +
                "\n\tДата начала: " + super.getDateStart() +
                "\n\tДата завершения: " + super.getDateEnd() +
                "\n\tСтатус: " + super.statusName() +
                "\n\tИсполнитель: " + executor;
    }
}
