package lv.iphone.musicplayer;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

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
