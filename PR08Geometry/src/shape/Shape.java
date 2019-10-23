package shape;

public class Shape {
    private String name;
    private int size;
    private ShapeType shapeType;
    private Color color;
    public enum Color { BLUE, GREEN, RED, YELLOW, BLACK }
    private int numberOfCorners;
    public enum ShapeType { SQUARE, CIRCLE, TRIANGLE }

    public Shape(String name, ShapeType shape, Color color, int size) {
        if (size < 0) {
            System.out.println("Cannot create negative sized object!");
        } else {
            this.name = name;
            this.size = size;
            this.color = color;
            shapeType = shape;
            switch (shape) {
                case SQUARE:
                    numberOfCorners = 4;
                    break;
                case CIRCLE:
                    numberOfCorners = 0;
                    break;
                case TRIANGLE:
                    numberOfCorners = 3;
                    break;
                default:
                    break;
            }
            System.out.println(this.toString());
        }
    }
    public void changeSize(int resize) {
        if (shapeType == ShapeType.CIRCLE) {
            System.out.println("Cannot resize a circle!");
        } else if (size + resize < 0) {
            System.out.println("Cannot resize to negative!");
        } else {
            int previousSize = size;
            size += resize;
            System.out.println("Shape " + this.name + " resized from " + previousSize + " to " + size + " points");
        }
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "Shape: " + shapeType.toString() + ", Number of angles: " + numberOfCorners
                + ", Color: " + color.toString() + ", Size: " + size;
    }
}
