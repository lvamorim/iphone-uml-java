package lv.iphone;

import lv.iphone.internetbrowser.InternetBrowser;
import lv.iphone.musicplayer.MusicPlayer;
import lv.iphone.phonedevice.PhoneDevice;

public class IPhone {
  public static void main(String[] args) throws Exception {
    PhoneDevice phoneDevice = new PhoneDevice();
    phoneDevice.call();
    phoneDevice.answerCall();
    phoneDevice.startVoicemail();

    InternetBrowser internetBrowser = new InternetBrowser();
    internetBrowser.showPage();
    internetBrowser.addNewTab();
    internetBrowser.refreshPage();

    MusicPlayer musicPlayer = new MusicPlayer();
    musicPlayer.play();
    musicPlayer.pause();
    musicPlayer.selectSong();
  }
}
