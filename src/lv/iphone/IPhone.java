package lv.iphone;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import lv.iphone.internetbrowser.InternetBrowser;
import lv.iphone.musicplayer.MusicPlayer;
import lv.iphone.phonedevice.PhoneDevice;

public class IPhone implements PhoneDevice, MusicPlayer, InternetBrowser {

  Scanner scanner = new Scanner(System.in);

  // PhoneDevice
  PhoneOperations phoneOperations = new PhoneOperations();

  @Override
  public void call() {
    System.out.println("Please, type a number to call:");

    try {
      int number = scanner.nextInt();

      if (Integer.toString(number).length() < 4) {
        throw new IllegalArgumentException();
      }

      phoneOperations.printMessageWithEllipsisAnimation(
        "Calling: " + phoneOperations.formatNumber(number),
        "Call started."
      );

    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please, type a number.");

    } catch (IllegalArgumentException e) {
      System.out.println("Invalid number length. Please, try again.");
    }
  }

  @Override
  public void answerCall() {
    int randomNumber = ThreadLocalRandom.current().nextInt(100000000, 1000000000);

    phoneOperations.printMessageWithEllipsisAnimation(
      phoneOperations.formatNumber(randomNumber) + " is calling",
      "Call answered."
    );
  }

  @Override
  public void startVoicemail() {
    System.out.println("Please, type a message:");

    try {
      String voicemail = scanner.nextLine();

      if (voicemail.isEmpty()) {
        throw new IllegalArgumentException();
      }

      phoneOperations.printMessageWithEllipsisAnimation(
        "Starting voicemail: " + voicemail,
        "Voicemail done."
      );

    } catch (IllegalArgumentException e) {
      System.out.println("Invalid message. Please, type something.");
    }
  }



  // MusicPlayer
  private SongList songList = new SongList();
  Song selectedSong = null;

  @Override
  public void play() {
    if (selectedSong == null) {
      selectedSong = songList.selectRandomSong();
    }

    System.out.println("Playing: " + selectedSong);
  }
  
  @Override
  public void pause() {
    System.out.println("Paused.");
  }

  @Override
  public void selectSong() {
    System.out.println("Please, type the number of the song you want to listen:");
    songList.showList();
    
    try {
      selectedSong = songList.findSongById(scanner.nextInt());
      System.out.println("Selected song: " + selectedSong);

    } catch (InputMismatchException e) {
      System.out.println("Wrong input. Please, type a number.");
    
    } catch (NoSuchElementException e) {
      System.out.println("Song not found. Try again.");
    }
  }

  

  // InternetBrowser
  InternetBrowserOperations internetBrowserOperations = new InternetBrowserOperations();

  @Override
  public void showPage() {
    internetBrowserOperations.domain = "google.com";
    internetBrowserOperations.printMessageWithUrl("Accessed");
  }

  @Override
  public void addNewTab() {
    System.out.println("Please, type a domain (e.g.: instagram.com):");

    try (Scanner scanner = new Scanner(System.in)) {
      internetBrowserOperations.domain = scanner.nextLine();

      if (internetBrowserOperations.domain.isBlank()) {
        throw new IllegalArgumentException();
      }

      internetBrowserOperations.printMessageWithUrl("New tab added");

    } catch (IllegalArgumentException e) {
      System.out.println("Invalid input. Please, insert a domain.");
    }
  }

  @Override
  public void refreshPage() {
    try {
      if (internetBrowserOperations.domain == null || internetBrowserOperations.domain.isBlank()) {
        throw new NullPointerException();
      }

      internetBrowserOperations.printMessageWithUrl("Refreshed");
      
    } catch (NullPointerException e) {
      System.out.println("There's no page to refresh. Please, first show a page or add a new tab.");
    }
  }
  
}

class PhoneOperations {
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

class Song {
  private static int nextId = 1;
  private int id;
  private String singer;
  private String name;

  Song(String singer, String name) {
    this.id = nextId++;
    this.singer = singer;
    this.name = name;
  }

  int getId() {
    return id;
  }
  
  @Override
  public String toString() {
    return String.format("%s - %s", singer, name);
  }
}


class SongList {
  private List<Song> songList = Arrays.asList(
    new Song("Trippie Redd ft. Playboi Carti", "Miss The Rage"),
    new Song("Arca", "Rakata")
  );

  void showList() {
    songList.forEach(song -> System.out.println(song.getId() + ": " + song));
  }

  Song findSongById(int id) {
    return songList.stream()
        .filter(song -> song.getId() == id)
        .findFirst()
        .orElseThrow(NoSuchElementException::new);
  }
  
  Song selectRandomSong() {
    return songList.get(new Random().nextInt(songList.size()));
  }
}

class InternetBrowserOperations {
  String domain;
  
  void printMessageWithUrl(String message) {
    System.out.println(message + ": https://" + domain);
  }
}
