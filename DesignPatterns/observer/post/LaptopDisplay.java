package DesignPatterns.observer.post;

public class LaptopDisplay implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("LaptopDisplay " + temperature);
    }
}
