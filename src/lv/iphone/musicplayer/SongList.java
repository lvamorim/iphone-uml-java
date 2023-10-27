package lv.iphone.musicplayer;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

class SongList {
  private List<Song> songList = Arrays.asList(
    new Song("Trippie Redd ft. Playboi Carti", "Miss The Rage"),
    new Song("Arca", "Rakata"),
    new Song("Lil Uzi Vert ft. BABYMETAL", "The End"),
    new Song("Yeat", "Flawlëss"),
    new Song("Kanye West", "Good Morning"),
    new Song("Mariah Carey ft. ODB", "Fantasy"),
    new Song("Ecco2k", "Peroxide")
  );
  Song selectedSong = null;

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
