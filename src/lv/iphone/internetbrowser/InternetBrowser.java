package lv.iphone.internetbrowser;

import lv.iphone.common.InputManager;

public class InternetBrowser {
  private String domain;
  
  private void printMessageWithUrl(String message) {
    System.out.println(message + ": https://" + domain);
  }

  public void showPage() {
    domain = "google.com";
    printMessageWithUrl("Accessed");
  }

  public void addNewTab() {
    System.out.println("Please, type a domain (e.g.: instagram.com):");

    try {
      domain = InputManager.readLine();

      if (domain.isBlank()) {
        throw new IllegalArgumentException();
      }

      printMessageWithUrl("New tab added");

    } catch (IllegalArgumentException e) {
      System.out.println("Invalid input. Please, insert a domain.");
    }
  }

  public void refreshPage() {
    try {
      if (domain == null || domain.isBlank()) {
        throw new NullPointerException();
      }

      printMessageWithUrl("Refreshed");
      
    } catch (NullPointerException e) {
      System.out.println("There's no page to refresh. Please, first show a page or add a new tab.");
    }
  }
}
