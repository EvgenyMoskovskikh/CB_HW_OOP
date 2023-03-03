package com.company.hw7FinalProject.figure;

import com.company.hw7FinalProject.Type;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> points) {

        super(points);

    }
    @Override
    public void calculateCenter() {
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < points.size(); i++) {
            sumX += points.get(i).getX();
            sumY += points.get(i).getY();
        }
        this.center = new Point(sumX / points.size(), sumY / points.size());
    }
    @Override
    public void calculatePerimetr() {
        perimetr = Math.sqrt(Math.pow(points.get(0).getX() - points.get(points.size() - 1).getX(), 2)
                + Math.pow(points.get(0).getY() - points.get(points.size() - 1).getY(), 2));
        for (int i = 0; i < points.size() - 1; i++) {
            perimetr += Math.sqrt(Math.pow(points.get(i).getX() - points.get(i + 1).getX(), 2)
                    + Math.pow(points.get(i).getY() - points.get(i + 1).getY(), 2));
        }
    }
    @Override
    public void calculateArea() {
        area = points.get(points.size()-1).getX() * points.get(0).getY()
                - points.get(points.size()-1).getY() * points.get(0).getX();
        for (int i = 0; i < points.size()-1; i++) {
            area += points.get(i).getX() * points.get(i + 1).getY()
                    - points.get(i).getY() * points.get(i + 1).getX();
        }
        area = 0.5 * Math.abs(area);
    }

    @Override
    public void move(Point vect) {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, new Point(points.get(i).getX() + vect.getX(),
                    points.get(i).getY() + vect.getY()));
        }
    }

    @Override
    public void rotate(double angle) {
        angle = angle * Math.PI / 180;
        for (int i = 0; i < points.size(); i++) {
            double x = (points.get(i).getX() - center.getX()) * Math.cos(angle) - (points.get(i).getY() - center.getY()) * Math.sin(angle);
            double y = (points.get(i).getX() - center.getX()) * Math.sin(angle) + (points.get(i).getY() - center.getY()) * Math.cos(angle);
            points.set(i, new Point(x+center.getX(), y+center.getY()));
        }

    }

    @Override
    public void scale(double scale) {
        for (int i = 0; i < points.size(); i++) {
            double x = (points.get(i).getX() - center.getX()) * scale + center.getX();
            double y = (points.get(i).getY() - center.getY()) * scale + center.getY();
            points.set(i, new Point(x, y));
        }
        calculateArea();
        calculatePerimetr();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon figure = (Polygon) o;
        return points.equals(figure.points);
    }
    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String getName() {
        return Type.valueOf(this.getClass().getSimpleName()).toString();
    }
    @Override
    public String toString () {
        return  " с вершинами в точках: " + points +"\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getArea()+ "\n ";
    }
    @Override
    public boolean containPoint(int x, int y, int multiplier) {
        boolean flag = false;
        for (int i = 0; i < this.getPoints().size(); i++) {
            int j = i == this.getPoints().size() - 1 ? 0 : i + 1;
            double x1 = this.getPoints().get(i).getX() * multiplier;
            double x2 = this.getPoints().get(j).getX() * multiplier;
            double y1 = this.getPoints().get(i).getY() * multiplier;
            double y2 = this.getPoints().get(j).getY() * multiplier;

            if(x2-x1!=0) {
                double a = (y2 - y1) / (x2 - x1);
                double b = y1 - a * x1;
                if ((Math.abs(y - (int) (a * x + b)) <= 2)) flag = true;
            }
            else{
                if ((Math.abs(x - x1) <= 2)&&(y>=Math.min(y1, y2) && y<=Math.max(y1, y2))) flag = true;
            }
        }
        return flag;
    }
}