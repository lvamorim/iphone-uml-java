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
          printPhoneAction(
            "Calling",
            inputPhoneNumber,
            "Call started."
          );
          break;
        }

      } catch (InputMismatchException e) {
        InputManager.printErrorMessage(
          "Invalid input. Please, type a number."
        );
      }
    }
  }

  public void answerCall() {
    DeviceRole.printDeviceRole();

    printPhoneAction(
      "Receiving call from",
      randomPhoneNumber,
      "Call answered."
    );
  }

  public void startVoicemail() {
    DeviceRole.printDeviceRole();

    printPhoneAction(
      "Starting voicemail to",
      randomPhoneNumber,
      "Voicemail done."
    );
  }
}
