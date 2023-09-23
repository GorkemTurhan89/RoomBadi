package screens;

import pages.MainPage;

public class Screens {
  public  Screens (){}
    private MainScreen mainScreen;
    public MainScreen mainScreen() {
        if (mainScreen == null) {
            mainScreen = new MainScreen();
        }
        return mainScreen;
    }

}
