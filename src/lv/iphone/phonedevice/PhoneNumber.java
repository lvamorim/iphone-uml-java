package lv.iphone.phonedevice;

import java.util.concurrent.ThreadLocalRandom;

class PhoneNumber {
  int inputPhoneNumber;
  int randomPhoneNumber = ThreadLocalRandom.current().nextInt(100000000, 1000000000);
  
  boolean isValidPhoneNumber() {
    int inputMinDigits = 3;

    if (Integer.toString(inputPhoneNumber).length() < inputMinDigits) {
      System.out.printf(
        "The number must have at least %d digits. Please, try again:\n",
        inputMinDigits
      );
      return false;
    }

    return true;
  }

  void printPhoneAction(String startMessage, int phoneNumber, String endMessage) {
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
