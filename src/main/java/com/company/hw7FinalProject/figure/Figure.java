package com.company.hw7FinalProject.figure;

import com.company.helper.ScannerHelper;
import com.company.hw7FinalProject.interfaces.Moveble;
import com.company.hw7FinalProject.interfaces.Rotateble;
import com.company.hw7FinalProject.interfaces.Scalable;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class Figure implements Moveble, Rotateble, Scalable, Serializable {
        private  static final long serialVersionUID = 1L;
    ArrayList<Point> points;
    Point center;
    double area;
    double perimetr;

    public Figure(ArrayList<Point> points) {
        this.points = points;
        this.calculateCenter();
        this.calculatePerimetr();
        this.calculateArea();
    }
    public static ArrayList<Point>  input () {
        ArrayList<Point> points = new ArrayList<>();
        boolean flag = true;
        double x, y;
        while (flag ){
            if (points.size()<2){
                points.add(getPoint());
            }
            else {
                System.out.println("Ввести еще одну координату? Y/N");
                switch (ScannerHelper.readString()) {
                    case "Y":
                        points.add(getPoint());
                        break;
                    case "N":
                        flag = false;
                        break;
                    default:
                        System.out.println("Введено некорректное значение");
                        break;
                }
            }
        }
        return points;
    }
    private static Point getPoint() {
        System.out.println("Введите х: ");
        double x = ScannerHelper.readDouble();
        System.out.println("Введите y: ");
        double y = ScannerHelper.readDouble();
        return new Point(x,y);
    }

    public abstract void calculateCenter();

    public Point getCenter() {
        return center;
    }

    public abstract void calculatePerimetr();

    public abstract void calculateArea();

    public double getPerimetr() {
        return perimetr;
    }

    public double getArea() {
        return area;
    }
    public ArrayList<Point> getPoints() {
        return points;
    }
    public abstract String getName();
    public abstract String toString ();

    public abstract boolean containPoint(int x, int y, int multiplier);

}