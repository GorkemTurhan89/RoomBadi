package pages;

public class Pages {
    public Pages (){

    }
    private MainPage mainPage;
    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }
}
