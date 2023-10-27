package lv.iphone.phonedevice;

import java.util.InputMismatchException;

import lv.iphone.common.DeviceRole;
import lv.iphone.common.InputManager;

public class PhoneDevice extends PhoneNumber {
  public void call() {
    DeviceRole.printDeviceRole();

    System.out.println("Please, type a number to call:");

    while (true) {
      try {
        inputPhoneNumber = InputManager.readInt();

        if (isValidPhoneNumber()) {
          printActionWithPhoneNumber(
            "Calling",
            inputPhoneNumber,
            "Call started."
          );
          break;
        }

        System.out.printf(
          "The number must have at least %d digits. Please, try again:\n",
          inputMinDigits
        );
        
      } catch (InputMismatchException e) {
        InputManager.printErrorMessage(
          "Invalid input. Please, type a number."
        );
      }
    }
  }

  public void answerCall() {
    DeviceRole.printDeviceRole();

    printActionWithPhoneNumber(
      "Receiving call from",
      randomPhoneNumber,
      "Call answered."
    );
  }

  public void startVoicemail() {
    DeviceRole.printDeviceRole();

    printActionWithPhoneNumber(
      "Starting voicemail to",
      randomPhoneNumber,
      "Voicemail done."
    );
  }
}
