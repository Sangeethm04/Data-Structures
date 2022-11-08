import java.util.Iterator;
import java.util.*;

public class RandomizedQueue < Item > implements Iterable < Item > {
    private int size;
    private Item[] items;
    int[] array;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        items = (Item[]) new Object[1];
        array = new int[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        if(size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = (int)(Math.random());
        Item item = items[random];
        items[random] = items[size - 1];
        items[size - 1] = null;
        size--;
        if(size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(int i) {
        int r = i + (int) (Math.random() * (size - i));
        items[r];
    }

    public void shuffle(Item[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
          // choose index uniformly in [i, n-1]
          int r = i + (int) (Math.random() * (n - i));
          Item swap = array[r];
          array[r] = array[i];
          array[i] = swap;
        }
      
      }
    
      public void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
          copy[i] = items[i];
        }
        items = copy;
      }

    // return an independent iterator over items in random order
    public Iterator < Item > iterator() {

    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> playlist = new RandomizedQueue<>();
        playlist.enqueue("Hello");
        playlist.enqueue("It's");
        playlist.enqueue("Me");

    }

}