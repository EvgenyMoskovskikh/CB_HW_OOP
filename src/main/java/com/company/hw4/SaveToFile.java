package com.company.hw4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveToFile implements Serializable {

    public static <T> void saveToFile(T t, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(t);
            System.out.println("***Сохранено***\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
