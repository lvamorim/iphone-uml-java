package lv.iphone.internetbrowser;

class Url {
  String domain = null;

  boolean isValidUrl() {
    if (domain == null || domain.isBlank()) {
      System.out.println("The domain can't be empty. Please, try again:");
      return false;
    }

    if (!domain.contains(".") || !domain.matches("^[a-zA-Z0-9.]*$")) {
      System.out.println("Invalid domain format. Please, try again:");
      return false;
    }

    return true;
  }

  void printActionWithUrl(String action) {
    System.out.println(action + ": https://" + domain);
  }
}
