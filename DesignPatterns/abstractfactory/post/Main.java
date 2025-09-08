package DesignPatterns.abstractfactory.post;

public class Main {
    public static void main(String args[]) {
        String theme = "DA1RK";
        UIFactory uiFactory;

        if (theme.equals("DARK")) {
            uiFactory = new DarkThemeFactory();
        } else {
            uiFactory = new LightThemeFactory();
        }

        Button btn = uiFactory.createButton();
        CheckBox cb = uiFactory.createCheckbox();

        btn.render();
        cb.render();
    }
}
