package pages;

public class Pages {
    public Pages() {

    }

    private MainPage mainPage;

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    private MessagesGoogle messagesGoogle;

    public MessagesGoogle messagesGoogle() {
        if (messagesGoogle == null) {
            messagesGoogle = new MessagesGoogle();
        }
        return messagesGoogle;
    }
}
//Step defition icerisinde fazla constructor kalabaligi olmamasi icin olusturulmustur