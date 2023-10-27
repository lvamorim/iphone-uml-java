package lv.iphone.phonedevice;

import java.util.concurrent.ThreadLocalRandom;

class PhoneNumber {
  int inputMinDigits = 3;
  int randomMinDigits = 100000000;
  int randomMaxDigits = 1000000000;
  int inputPhoneNumber;
  int randomPhoneNumber = ThreadLocalRandom.current().nextInt(randomMinDigits, randomMaxDigits);

  boolean isValidPhoneNumber() {
    if (Integer.toString(inputPhoneNumber).length() < inputMinDigits) {
      return false;
    }

    return true;
  }

  void printActionWithPhoneNumber(String startMessage, int phoneNumber, String endMessage) {
    System.out.print(startMessage + " +" + phoneNumber + " ");

    for (int i = 0; i < 3; i++) {
      System.out.print(".");

      try {
        Thread.sleep(1000);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("\n" + endMessage);
  }
}
