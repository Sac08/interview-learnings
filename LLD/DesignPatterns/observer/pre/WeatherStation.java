package LLD.DesignPatterns.observer.pre;

public class WeatherStation {
    String temperature;

    public void setTemperature(String temp) {
        this.temperature = temp;
        callDisplay();
    }

    void callDisplay() {
        new PhoneDisplay().update();
        new TVDisplay().update();
        new LaptopDisplay().update();

    }
}
class PhoneDisplay {
    void update() {
        System.out.println("Phone Display");
    }
}

class TVDisplay {
    void update() {
        System.out.println("TVDisplay Display");
    }
}


class LaptopDisplay {
    void update() {
        System.out.println("LaptopDisplay Display");
    }
}
/*
Observer Pattern keeps publisher and subscribers loosely coupled, flexible, and extensible.
Without it, you get rigid, hardcoded, unscalable, OCP-violating code.
 */