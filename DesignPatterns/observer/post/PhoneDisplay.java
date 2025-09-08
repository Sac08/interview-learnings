package DesignPatterns.observer.post;

public class PhoneDisplay implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("PhoneDisplay "+ temperature);
    }
}