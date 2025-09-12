package LLD.DesignPatterns.observer.post;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationSubject {
    String temp;

    List<Observer> list = new ArrayList<>();

    public void addObserver(Observer o) {
        list.add(o);
    }

    public void removeObserver(Observer o) {
        list.remove(o);
    }

    public void updateObservers(String temp) {
        for (Observer o:list) {
            o.update(temp);
        }
    }

    public void setTemp(String temp) {
        this.temp = temp;
        updateObservers(temp);
    }


}
