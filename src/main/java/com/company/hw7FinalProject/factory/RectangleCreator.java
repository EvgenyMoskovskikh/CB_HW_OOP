package com.company.hw7FinalProject.factory;

import com.company.hw7FinalProject.figure.Point;
import com.company.hw7FinalProject.figure.Figure;
import com.company.hw7FinalProject.figure.Rectangle;

import java.util.ArrayList;
public class RectangleCreator extends FigureCreator {

    @Override
    public Figure create (ArrayList<Point> points) {

        return new Rectangle(points);
    }
}