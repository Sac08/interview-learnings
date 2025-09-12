package LLD.DesignPatterns.factory.previous;

import LLD.DesignPatterns.factory.post.Rectangle;
import LLD.DesignPatterns.factory.post.Shape;
import LLD.DesignPatterns.factory.post.Square;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape square = new Square();

        rectangle.draw();
        square.draw();
    }
}
