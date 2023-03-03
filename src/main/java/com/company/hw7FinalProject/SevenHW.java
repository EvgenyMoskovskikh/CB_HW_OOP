package com.company.hw7FinalProject;

import com.company.Menu;
import com.company.helper.ScannerHelper;
import com.company.hw7FinalProject.data.SaveToFile;
import com.company.hw7FinalProject.factory.*;
import com.company.hw7FinalProject.figure.*;

import java.util.ArrayList;
import java.util.Collections;


public class SevenHW {
    private String file;
    private ArrayList<Figure> figures;
    private static final String SELECT_ACTION = "Выберите действие: ";
    private static String MENU = "Выберите нужный пункт меню:\n" +
            "1 - Вывести все фигуры\n" +
            "2 - Добавить фигуру\n" +
            "3 - Изменить фигуру\n" +
            "4 - Удалить фигуру\n" +
            "5 - Вернуться в главное меню\n" +
            "0 - Выход";
    private static String SUB_MENU = "Выберете действие:\n" +
            "1 - Поворот фигуры\n" +
            "2 - Перемещение фигуры\n" +
            "3 - Масштабирование фигуры\n" +
            "4 - Вернуться в главное меню";

    public SevenHW(String file, ArrayList<Figure> figures) {
        this.file = file;
        this.figures = figures;
    }

    public static ArrayList<Figure> initialize() {
        ArrayList<Figure> figures = new ArrayList<>();
        ArrayList<Point> triangle1 = new ArrayList<>();
        Collections.addAll(triangle1, new Point(5, 5), new Point(5, 1), new Point(1, 1));
        Triangle t1 = new Triangle(triangle1);
        ArrayList<Point> rectangle = new ArrayList<>();
        Collections.addAll(rectangle, new Point(1, 1), new Point(5, 1), new Point(5, 3), new Point(1, 3));
        Rectangle r = new Rectangle(rectangle);
        ArrayList<Point> circle = new ArrayList<>();
        Collections.addAll(circle, new Point(5, 5), new Point(5, 1));
        Circle c = new Circle(circle);
        Collections.addAll(figures, t1, r, c);
        return figures;
    }

    public static void menu(ArrayList<Figure> figures, String file) {
        while (true) {
            System.out.println(MENU);
            switch (ScannerHelper.getIntFromInput(SELECT_ACTION)) {
                case 1:
                    printFigure(figures);
                    if (figures.size() == 0) {
                        System.out.println("Нет сохраненных фигур!");
                    }
                    break;
                case 2:
                    getFigure(figures);
                    SaveToFile.saveToFile(figures, file);
                    System.out.println("Объект сохранен");
                    break;
                case 3:
                    startActionFigureMenu(figures, file);
                    SaveToFile.saveToFile(figures, file);
                    break;
                case 4:
                    removeFigure(figures);
                    SaveToFile.saveToFile(figures, file);
                    break;
                case 5:
                    Menu.startMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    static void printFigure(ArrayList<Figure> figures) {
        int i = 1;
        for (Figure f : figures) {
            System.out.println(i + ". " + f.getName() + f);
            i++;
        }
    }

    public static Figure getFigure(ArrayList<Figure> figures) {
        ArrayList<Point> points = Figure.input();
        FigureCreator figureCreator = selectFigure(points);
        Figure figure = figureCreator.create(points);
        figures.add(figure);
        return figure;
    }

    public static FigureCreator selectFigure(ArrayList<Point> points) {
        FigureCreator figureCreator;
        switch (points.size() - 1) {
            case 1:
                figureCreator = new CircleCreator();
                break;
            case 2:
                figureCreator = new TriangleCreator();
                break;
            case 3:
                figureCreator = new RectangleCreator();
                break;
            default:
                figureCreator = new PolygonCreator();
        }
        return figureCreator;
    }


    private static void removeFigure(ArrayList<Figure> figures) {
        int number;
        System.out.println("Доступно фигур: " + figures.size() + ".\nВведите порядковый номер (начиная с 1) удаляемой фигуры");
        number = ScannerHelper.readInt(0, figures.size() + 1);
        figures.remove(figures.get(number - 1));

    }

    private static void startActionFigureMenu(ArrayList<Figure> figures, String file) {
        int number;
        System.out.println("Доступно фигур: " + figures.size() + ".\nВведите порядковый номер (начиная с 1) для вывода желаемой фигуры");
        number = ScannerHelper.readInt(0, figures.size() + 1);
        Figure figure = figures.get(number - 1);
        actionFigure(figure, figures, file);
    }


    private static void actionFigure(Figure figure, ArrayList<Figure> figures, String file) {
        boolean isAction = true;
        Figure f = figure;
        while (isAction) {
            System.out.println(SUB_MENU);
            switch (ScannerHelper.getIntFromInput(SELECT_ACTION)) {
                case 1:
                    rotateFigure(f);
                    saveFigure(figures, file);
                    break;
                case 2:
                    moveFigure(f);
                    saveFigure(figures, file);
                    break;
                case 3:
                    scaleFigure(f);
                    saveFigure(figures, file);
                    break;
                case 4:
                    isAction = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }

    private static void scaleFigure(Figure f) {
        System.out.println("Введите параметр масштабирования в формате #.## \n" +
                "(от 0 до 1 - для уменьшения, больше 1 - для увеличения)");
        double scale = ScannerHelper.readDouble(0);
        f.scale(scale);
        System.out.println(f.getName() + " после масштабирования\n" + f.toString()); //вывод нужной фигуры
    }

    private static void moveFigure(Figure f) {
        System.out.println("Введите дистанцию на которую передвинуть по горизонтали");
        int x = ScannerHelper.getIntFromInput("координата по X: ");
        System.out.println("Введите дистанцию на которую передвинуть по вертикали");
        int y = ScannerHelper.getIntFromInput("координата по Y: ");
        Point vect = new Point(x, y);
        f.move(vect);
        System.out.println(f.getName() + " после перемещения\n" + f.toString()); //вывод нужной фигуры
    }

    private static void rotateFigure(Figure f) {
        System.out.println("Введите градусы в формате #.##");
        double angle = ScannerHelper.readDouble();
        f.rotate(angle);
        System.out.println(f.getName() + " после поворота\n" + f.toString()); //вывод нужной фигуры
    }

    private static void saveFigure(ArrayList<Figure> figures, String file) {
        boolean flag = true;
        while (flag) {
            System.out.println("Выберете действие:\n1 - Сохранить\n2 - Отмена");
            switch (ScannerHelper.getIntFromInput(SELECT_ACTION)) {
                case 1:
                    SaveToFile.saveToFile(figures, file);
                    System.out.println("Объект сохранен");
                    flag = false;
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }
}
