package main;

import canvas.Canvas;
import shape.Shape;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Shape square = new Shape("Square", Shape.ShapeType.SQUARE, Shape.Color.BLUE, 0);
        canvas.addShape(square);
        square.changeSize(2);
        square.changeSize(-2);
        square.changeSize(-5);
        System.out.println(canvas.getShapes());
        Shape circle = new Shape("Circle", Shape.ShapeType.CIRCLE, Shape.Color.GREEN, 10);
        canvas.addShape(circle);
        circle.changeSize(10);
        System.out.println(canvas.getShapes());
        Shape circle2 = new Shape("Circle 2", Shape.ShapeType.CIRCLE, Shape.Color.BLACK, -2);
        Shape circle3 = new Shape("Circle 3", Shape.ShapeType.CIRCLE, Shape.Color.RED, 2);
    }
}
