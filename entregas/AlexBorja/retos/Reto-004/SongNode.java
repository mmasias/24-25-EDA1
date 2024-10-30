class SongNode {
   private Song song;
   private SongNode next;
   private SongNode previous;

   public SongNode(Song song) {
      this.song = song;
      this.next = null;
      this.previous = null;
   }

   public Song getSong() {
      return this.song;
   }

   public SongNode getNext() {
      return this.next;
   }

   public SongNode getPrevious() {
      return this.previous;
   }

   public void setNext(SongNode next) {
      this.next = next;
   }

   public void setPrevious(SongNode previous) {
      this.previous = previous;
   }

   public String toString() {
      return this.song.toString();
   }
}
