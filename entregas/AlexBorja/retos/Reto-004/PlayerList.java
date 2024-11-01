class PlayerList {
   private SongNode head;
   private SongNode tail;
   private SongNode current;
   private int size;

   public PlayerList() {
      this.head = null;
      this.tail = null;
      this.current = null;
      this.size = 0;
   }

   public void addSong(Song song) {
      SongNode newNode = new SongNode(song);
      if (this.head == null) {
         this.head = newNode;
         this.tail = newNode;
      } else {
         this.tail.setNext(newNode);
         newNode.setPrevious(this.tail);
         this.tail = newNode;
      }
      this.size++;
   }

   public Song removeSong() {
      if (this.head == null) {
         return null;
      }
      Song song = this.head.getSong();
      this.head = this.head.getNext();
      if (this.head != null) {
         this.head.setPrevious(null);
      }
      this.size--;
      return song;
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

   public boolean isEmpty() {
      return this.head == null;
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

   public int getSize() {
      return this.size;
   }

   public SongNode getHead() {
      return this.head;
   }

   public SongNode getTail() {
      return this.tail;
   }

   public void clear() {
      this.head = null;
      this.tail = null;
      this.size = 0;
   }
}
