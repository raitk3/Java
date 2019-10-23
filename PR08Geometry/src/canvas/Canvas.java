package canvas;

import shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private List<Shape> shapes;

    public Canvas() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        System.out.println(shape.getName() + " added to this canvas.");
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
