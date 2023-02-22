package com.company.hw4;

public enum Priority {
    important("Важный"),
    basic("Основной"),
    ordinary("Обычный");

    private String title;

    Priority(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
