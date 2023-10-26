package lv.iphone.phonedevice;

import java.util.InputMismatchException;
import java.util.concurrent.ThreadLocalRandom;

import lv.iphone.common.InputManager;

public class PhoneDevice extends FormatNumberAndMessage {
  public void call() {
    System.out.println("Please, type a number to call:");

    try {
      int number = InputManager.readInt();

      if (Integer.toString(number).length() < 4) {
        throw new IllegalArgumentException();
      }

      printMessageWithEllipsisAnimation(
        "Calling: " + formatNumber(number),
        "Call started."
      );

    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please, type a number.");

    } catch (IllegalArgumentException e) {
      System.out.println("Invalid number length. Please, try again.");
    }
  }

  public void answerCall() {
    int randomNumber = ThreadLocalRandom.current().nextInt(100000000, 1000000000);

    printMessageWithEllipsisAnimation(
      formatNumber(randomNumber) + " is calling",
      "Call answered."
    );
  }

  public void startVoicemail() {
    printMessageWithEllipsisAnimation(
      "Starting voicemail",
      "Voicemail done."
    );
  }
}
