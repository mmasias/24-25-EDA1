class Playlist {
   private SongNode head;
   private SongNode tail;
   private int size;
   private String name;

   public Playlist(String name) {
      this.name = name;
      this.head = null;
      this.tail = null;
      this.size = 0;
   }

   public String getName() {
      return this.name;
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

   public void removeSong(String title) {
      SongNode current = this.head;
      while (current != null) {
         if (current.getSong().getTitle().equals(title)) {
            if (current == this.head) {
               this.head = current.getNext();
               if (this.head != null) {
                  this.head.setPrevious(null);
               }
            } else if (current == this.tail) {
               this.tail = current.getPrevious();
               this.tail.setNext(null);
            } else {
               current.getPrevious().setNext(current.getNext());
               current.getNext().setPrevious(current.getPrevious());
            }
            this.size--;
            return;
         }
         current = current.getNext();
      }
   }

   public void removeSong(Song song) {
      SongNode current = this.head;
      while (current != null) {
         if (current.getSong().equals(song)) {
            if (current == this.head) {
               this.head = current.getNext();
               if (this.head != null) {
                  this.head.setPrevious(null);
               }
            } else if (current == this.tail) {
               this.tail = current.getPrevious();
               this.tail.setNext(null);
            } else {
               current.getPrevious().setNext(current.getNext());
               current.getNext().setPrevious(current.getPrevious());
            }
            this.size--;
            return;
         }
         current = current.getNext();
      }
   }

   public Song getSong(int idx) {
      SongNode current = this.head;
      int i = 0;
      while (current != null) {
         if (i == idx) {
            return current.getSong();
         }
         i++;
         current = current.getNext();
      }
      return null;
   }

   public void displaySongs() {
      SongNode current = this.head;
      int idx = 1;
      while (current != null) {
         System.out.println("" + idx + ". " + current.toString());
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

   public boolean isEmpty() {
      return this.size == 0;
   }
}
