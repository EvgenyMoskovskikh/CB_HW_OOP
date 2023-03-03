package com.company.hw7FinalProject.factory;

import com.company.hw7FinalProject.figure.Point;
import com.company.hw7FinalProject.figure.Figure;
import com.company.hw7FinalProject.figure.Polygon;

import java.util.ArrayList;

public class PolygonCreator implements FigureCreator {

    @Override
    public Figure create (ArrayList<Point> points) {

        return new Polygon(points);
    }
}
