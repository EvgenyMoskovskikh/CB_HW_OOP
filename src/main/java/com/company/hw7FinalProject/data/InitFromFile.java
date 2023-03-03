package com.company.hw7FinalProject.data;

import com.company.hw7FinalProject.figure.Figure;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class InitFromFile {
    public static ArrayList<Figure> initFromFile(String file) {
        ArrayList<Figure> figures = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            figures = (ArrayList<Figure>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return figures;
    }
}
