package lv.iphone.common;

import java.util.Scanner;

public class InputManager {
  private static Scanner scanner = new Scanner(System.in);

  public static String readLine() {
    return scanner.nextLine();
  }
  
  public static int readInt() {
    return scanner.nextInt();
  }
}
