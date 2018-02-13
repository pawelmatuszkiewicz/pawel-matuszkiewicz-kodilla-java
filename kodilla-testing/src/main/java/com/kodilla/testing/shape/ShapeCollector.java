package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        Shape shape = null;

        if(n >= 0 && n < shapes.size()) {
            shape = shapes.get(n);
        }

        return shape;
    }

    public void showFigures() {

        int i = 1;
        for(Shape shape : shapes) {
            System.out.println("Figure #" + i++ + "  " + shape.getShapeName()
                                + "  area: " + shape.getField());
        }
    }

    public int getFiguresQuantity() {
        return shapes.size();
    }
}
