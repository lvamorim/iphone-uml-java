import lv.iphone.IPhone;

public class App {
    public static void main(String[] args) throws Exception {
        IPhone iphone = new IPhone();
        iphone.call();
        iphone.answerCall();
        iphone.startVoicemail();
        iphone.play();
        iphone.pause();
        iphone.selectSong();
        iphone.showPage();
        iphone.addNewTab();
        iphone.refreshPage();
    }
}
