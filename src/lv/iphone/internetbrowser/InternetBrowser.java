package lv.iphone.internetbrowser;

import java.util.InputMismatchException;

import lv.iphone.common.DeviceRole;
import lv.iphone.common.InputManager;

public class InternetBrowser extends Url {
  public void showPage() {
    DeviceRole.printDeviceRole();

    domain = "google.com";
    printActionWithUrl("Accessed");
  }

  public void addNewTab() {
    DeviceRole.printDeviceRole();

    System.out.println("Please, type a domain (e.g.: instagram.com):");

    while (true) {
      try {
        domain = InputManager.readLine();
        
        if (isValidUrl()) {
          printActionWithUrl("New tab added");
          break;
        }
        
      } catch (InputMismatchException e) {
        InputManager.printErrorMessage(
          "Invalid input. Please, insert a domain."
        );
      }
    }
  }

  public void refreshPage() {
    DeviceRole.printDeviceRole();

    if (isValidUrl()) {
      printActionWithUrl("Refreshed");
      return;
    }

    System.out.println(
      "There's no page to refresh. Please, first show a page or add a new tab."
    );
  }
}
