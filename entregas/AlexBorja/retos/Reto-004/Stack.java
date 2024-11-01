class Stack {
   // make the stack to store the history of songs
   private Song[] songs;
   private int size;
   private int capacity;

   public Stack(int capacity) {
      this.capacity = capacity;
      this.songs = new Song[capacity];
      this.size = 0;
   }

   public void push(Song song) {
      if (size == capacity) {
         System.out.println("Stack is full");
         return;
      }
      songs[size++] = song;
   }

   public Song pop() {
      if (size == 0) {
         System.out.println("Stack is empty");
         return null;
      }
      return songs[--size];
   }

   public void display() {
      for (int i = size - 1; i >= 0; i--) {
         System.out.println(songs[i]);
      }
   }

   public int getSize() {
      return size;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public boolean isFull() {
      return size == capacity;
   }

   public Song peek() {
      if (size == 0) {
         throw new IllegalStateException("Stack is empty");
      }
      return songs[size - 1];
   }
}
