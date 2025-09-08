package DesignPatterns.abstractfactory.post;

public interface UIFactory {
    Button createButton();
    CheckBox createCheckbox();
}

class LightThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new LightCheckBox();

    }
}

class DarkThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new DarkCheckBox();

    }
}

