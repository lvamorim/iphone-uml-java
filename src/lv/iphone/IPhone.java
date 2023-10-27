package lv.iphone;

import lv.iphone.common.DeviceRole;

public class IPhone extends DeviceRole {
  public static void main(String[] args) throws Exception {
    phoneDevice.call();
    phoneDevice.answerCall();
    phoneDevice.startVoicemail();

    internetBrowser.showPage();
    internetBrowser.addNewTab();
    internetBrowser.refreshPage();

    musicPlayer.play();
    musicPlayer.pause();
    musicPlayer.selectSong();
  }
}
