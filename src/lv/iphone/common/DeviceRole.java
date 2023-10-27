package lv.iphone.common;

import lv.iphone.internetbrowser.InternetBrowser;
import lv.iphone.musicplayer.MusicPlayer;
import lv.iphone.phonedevice.PhoneDevice;

public class DeviceRole {
  public static PhoneDevice phoneDevice = new PhoneDevice();
  public static InternetBrowser internetBrowser = new InternetBrowser();
  public static MusicPlayer musicPlayer = new MusicPlayer();
  
  private static String divider() {
    return "\n" + "-".repeat(70) + "\n";
  }

  public static void printDeviceRole() {
    System.out.println(
      divider()
      +
      Thread.currentThread().getStackTrace()[2]
        .getClassName()
        .split("\\.")[3]
        .replaceAll("([a-z])([A-Z])", "$1 $2")
        .toUpperCase()
      +
      divider()
    );
  }
}
