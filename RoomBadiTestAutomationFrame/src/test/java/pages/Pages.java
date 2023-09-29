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

    private SignUpPage signUpPage;

    public SignUpPage signUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }

    private SignUpOdaBul signUpOdaBul;

    public SignUpOdaBul signUpOdaBul() {
        if (signUpOdaBul == null) {
            signUpOdaBul = new SignUpOdaBul();
        }
        return signUpOdaBul;
    }

    private ProfiliGoster profiliGoster;

    public ProfiliGoster profiliGoster() {
        if (profiliGoster == null) {
            profiliGoster = new ProfiliGoster();
        }
        return profiliGoster;
    }
}
//Step defition icerisinde fazla constructor kalabaligi olmamasi icin olusturulmustur