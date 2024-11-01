class PlayerList extends Playlist {
   private SongNode current;

   public PlayerList(String name) {
      super(name);
      this.current = null;
   }

   public Song getSong() {
      if (this.head == null) {
         return null;
      }
      this.current = this.head;
      return this.head.getSong();
   }

   public Song getNextSong() {
      if (this.current == null) {
         return this.getSong();
      }
      this.current = this.current.getNext();
      if (this.current == null) {
         this.current = this.head;
      }
      return this.current.getSong();
   }

   public Song getPreviousSong() {
      if (this.current == null) {
         return this.getSong();
      }
      this.current = this.current.getPrevious();
      if (this.current == null) {
         this.current = this.tail;
      }
      return this.current.getSong();
   }

   public Song shuffle() {
      if (this.head == null) {
         return null;
      }
      int random = (int) (Math.random() * this.size);
      SongNode current = this.head;
      for (int i = 0; i < random; i++) {
         current = current.getNext();
      }
      this.current = current;
      return current.getSong();
   }

   public void display() {
      SongNode current = this.head;
      int idx = 1;
      while (current != null) {
         if (current == this.current)
            System.out.println("-> " + idx + ". " + current.toString());
         else
            System.out.println(idx + ". " + current.toString());
         idx++;
         current = current.getNext();
      }
   }
}
