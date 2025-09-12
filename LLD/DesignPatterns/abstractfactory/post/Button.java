package LLD.DesignPatterns.abstractfactory.post;

public interface Button {
    void render();
}

class LightButton implements Button {

    @Override
    public void render() {
        System.out.println("LightButton");
    }
}

class DarkButton implements Button {

    @Override
    public void render() {
        System.out.println("DarkButton");
    }
}
