package lv.iphone.musicplayer;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import lv.iphone.common.DeviceRole;
import lv.iphone.common.InputManager;

public class MusicPlayer extends SongList {
  public void play() {
    DeviceRole.printDeviceRole();

    if (selectedSong == null) {
      selectedSong = selectRandomSong();
    }

    System.out.println("Playing: " + selectedSong);
  }

  public void pause() {
    DeviceRole.printDeviceRole();

    System.out.println("Paused.");
  }

  public void selectSong() {
    DeviceRole.printDeviceRole();

    System.out.println("Please, type the number of the song you want to listen:");
    
    while (true) {
      try {
        showList();

        selectedSong = findSongById(InputManager.readInt());
        System.out.println("Selected song: " + selectedSong);
        break;

      } catch (InputMismatchException e) {
        InputManager.printErrorMessage(
          "Wrong input. Please, type a number:"
        );
      
      } catch (NoSuchElementException e) {
        InputManager.printErrorMessage(
          "Song not found. Please, try again:"
        );

      }
    }
  }
}
