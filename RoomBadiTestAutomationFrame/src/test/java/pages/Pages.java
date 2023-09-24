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

    private YeniIlanPage yeniIlanPage;

    public YeniIlanPage yeniIlanPage() {
        if (yeniIlanPage == null) {
            yeniIlanPage = new YeniIlanPage();
        }
        return yeniIlanPage;
    }

    private EvDetaylari evDetaylari;

    public EvDetaylari evDetaylari() {
        if (evDetaylari == null) {
            evDetaylari = new EvDetaylari();
        }
        return evDetaylari;
    }
}
//Step defition icerisinde fazla constructor kalabaligi olmamasi icin olusturulmustur