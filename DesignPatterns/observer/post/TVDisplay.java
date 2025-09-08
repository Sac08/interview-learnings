package DesignPatterns.observer.post;

public class TVDisplay implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("TVDisplay "+ temperature);
    }
}