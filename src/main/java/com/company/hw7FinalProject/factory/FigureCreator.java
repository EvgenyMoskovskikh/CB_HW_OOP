package com.company.hw7FinalProject.factory;

import com.company.hw7FinalProject.figure.Point;
import com.company.hw7FinalProject.figure.Figure;

import java.util.ArrayList;

public abstract class FigureCreator {


    public abstract Figure create(ArrayList<Point> points);
}


