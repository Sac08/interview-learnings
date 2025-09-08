package DesignPatterns.observer.post;

public class Main {
    public static void main(String args[]) {
        Observer phone = new PhoneDisplay();
        Observer laptop = new LaptopDisplay();
        Observer tv = new TVDisplay();

        WeatherStationSubject w = new WeatherStationSubject();

        w.addObserver(phone);
        w.addObserver(laptop);
        w.addObserver(tv);

        w.setTemp("35");
        w.setTemp("50");
    }
}
