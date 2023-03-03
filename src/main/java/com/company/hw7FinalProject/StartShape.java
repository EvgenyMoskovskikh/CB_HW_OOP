package com.company.hw7FinalProject;

import com.company.hw7FinalProject.data.InitFromFile;
import com.company.hw7FinalProject.data.SaveToFile;
import com.company.hw7FinalProject.figure.Figure;

import java.util.ArrayList;

import static com.company.hw7FinalProject.SevenHW.menu;

public class StartShape {
    public static final String file = ("src/main/java/com/company/hw7FinalProject/data/template.txt");

    public static void startApp() {
        ArrayList<Figure> figures = InitFromFile.initFromFile(file);
        if (figures.size() == 0) {
            figures = SevenHW.initialize();
            SaveToFile.saveToFile(figures, file);
        }
        menu(figures, file);

    }


}
