package DesignPatterns.abstractfactory.pre;

class DarkButton {
    void render() {
        System.out.println("Dark Button");
    }
}

class LightButton {
    void render() {
        System.out.println("Light Button");
    }
}

class DarkCheckbox {
    void render() {
        System.out.println("Dark Checkbox");
    }
}

class LightCheckbox {
    void render() {
        System.out.println("Light Checkbox");
    }
}

public class Main {
    public static void main(String[] args) {
        String theme = "dark";  // config or runtime decision

        if (theme.equals("dark")) {
            DarkButton btn = new DarkButton();
            DarkCheckbox cb = new DarkCheckbox();
            btn.render();
            cb.render();
        } else {
            LightButton btn = new LightButton();
            LightCheckbox cb = new LightCheckbox();
            btn.render();
            cb.render();
        }
    }
}

