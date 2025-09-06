package DesignPatterns.factory.post;

public class ShapeFactory {

    // Factory method
    public Shape getShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
