package lv.iphone.musicplayer;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import lv.iphone.common.InputManager;

public class MusicPlayer {
  private SongList songList = new SongList();
  private Song selectedSong = null;

  public void play() {
    if (selectedSong == null) {
      selectedSong = songList.selectRandomSong();
    }

    System.out.println("Playing: " + selectedSong);
  }

  public void pause() {
    System.out.println("Paused.");
  }

  public void selectSong() {
    System.out.println("Please, type the number of the song you want to listen:");
    songList.showList();
    
    try {
      selectedSong = songList.findSongById(InputManager.readInt());
      System.out.println("Selected song: " + selectedSong);

    } catch (InputMismatchException e) {
      System.out.println("Wrong input. Please, type a number.");
    
    } catch (NoSuchElementException e) {
      System.out.println("Song not found. Try again.");
    }
  }
}
