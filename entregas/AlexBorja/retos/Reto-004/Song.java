class Song {
   private String title;
   private String artist;
   private int duration;
   private boolean favorite;

   public Song(String title, String artist, int duration) {
      this.title = title;
      this.artist = artist;
      this.duration = duration;
      this.favorite = false;
    }

   public String toString() {
      return "" + this.title+ " - " + this.artist+ " (" + this.duration + " s)";
   }

   public String getTitle() {
      return this.title;
   }

   public String getArtist() {
      return this.artist;
   }
}
