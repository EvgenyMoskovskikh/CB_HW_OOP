package com.company.hw7FinalProject.figure;

import com.company.hw7FinalProject.Type;

import java.util.ArrayList;

public class Circle extends Figure {

    private double radius;
    private Point center;

    public Circle(ArrayList<Point> points) {
        super(points);
        this.calculateCenter();
        this.calculateRadius();
        this.calculatePerimetr();
        this.calculateArea();
    }

    @Override
    public void calculateCenter() {
        this.center = this.points.get(0);
    }

    public Point getCenter() {
        return center;
    }

    public void calculateRadius() {
        this.radius = Math.sqrt(Math.pow(points.get(0).getX() - points.get(points.size() - 1).getX(), 2)
                + Math.pow(points.get(0).getY() - points.get(points.size() - 1).getY(), 2));
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimetr() {
        perimetr = 2 * Math.PI * radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * Math.pow(radius, 2);
    }


    @Override
    public String getName() {
        return Type.valueOf(this.getClass().getSimpleName()).toString();
    }

    @Override
    public String toString() {

        return " c центром в точке A " + points.get(0) + " и радиусом = " + radius + "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getArea() + "\n ";
    }

    @Override
    public boolean containPoint(int x, int y, int multiplier) {
        this.getCenter();

        double distance = Math.sqrt(Math.pow(x - this.getCenter().getX() * multiplier, 2)
                + Math.pow(y - this.getCenter().getY() * multiplier, 2));
        return (Math.abs(radius * multiplier - distance) < 2);
    }

    @Override
    public void move(Point vect) {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, new Point(points.get(i).getX() + vect.getX(),
                    points.get(i).getY() + vect.getY()));
        }
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void scale(double scale) {
        setRadius(this.radius * scale);

        points.get(1).setX(points.get(1).getX() * scale);
        points.get(1).setY(points.get(1).getY() * scale);

        calculateArea();
        calculatePerimetr();
    }

    @Override
    public void rotate(double angle) {
        System.out.println("Вращение окружности не производится");
    }


}