package lv.iphone.musicplayer;

class Song {
  private int id;
  private static int nextId = 1;
  private String singer;
  private String title;

  Song(String singer, String title) {
    this.id = nextId++;
    this.singer = singer;
    this.title = title;
  }

  int getId() {
    return id;
  }
  
  @Override
  public String toString() {
    return String.format("%s - %s", singer, title);
  }
}
