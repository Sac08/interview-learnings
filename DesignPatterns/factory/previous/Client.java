package DesignPatterns.factory.previous;

import DesignPatterns.factory.post.Rectangle;
import DesignPatterns.factory.post.Shape;
import DesignPatterns.factory.post.Square;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape square = new Square();

        rectangle.draw();
        square.draw();
    }
}
