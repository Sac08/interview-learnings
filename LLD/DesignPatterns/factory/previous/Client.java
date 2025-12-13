package LLD.DesignPatterns.factory.previous;

import LLD.DesignPatterns.factory.post.Rectangle;
import LLD.DesignPatterns.factory.post.Shape;
import LLD.DesignPatterns.factory.post.Square;

public class Client {
    public static void main(String[] args) {
        String type = "rectangle";

        Shape shape = null;

       if ("rectangle".equals(type)) {
            shape = new Rectangle();
        } else if ("square".equals(type)) {
            shape = new Square();
        }

        shape.draw();
    }
}
