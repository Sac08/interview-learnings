package DesignPatterns.abstractfactory.post;

public interface CheckBox {
    void render();
}

class LightCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("LightCheckBox");
    }
}


class DarkCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("DarkCheckBox");
    }
}
