package lv.iphone.phonedevice;

class FormatNumberAndMessage {
  String formatNumber(int number) {
    return "+" + number;
  }

  void printMessageWithEllipsisAnimation(String startMessage, String endMessage) {
    System.out.print(startMessage + " ");

    for (int i = 0; i < 3; i++) {
      System.out.print(".");

      try {
        Thread.sleep(500);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("\n" + endMessage);
  }
}
