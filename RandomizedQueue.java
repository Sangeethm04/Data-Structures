import java.util.Iterator;
import java.util.*;
import java.util.NoSuchElementException;

public class RandomizedQueue < Item > implements Iterable < Item > {
    private int size;
    private Item[] items;

    // construct an empty randomized queue
    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }
    // return an independent iterator over items in random order
    public Iterator < Item > iterator() {
        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator < Item > {
        private int i = 0;
        private Item[] itemsCopy;


        @SuppressWarnings("unchecked")
        public RandomizedQueueIterator() {
            itemsCopy = (Item[]) new Object[size];
            for (int j = 0; j < size; j++) {
                itemsCopy[j] = items[j];
            }
            shuffle(itemsCopy);
            for (int j = 0; j < size; j++) {
                items[j] = itemsCopy[j];
            }
        }

        public boolean hasNext() {
            return i < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[i++];
        }
    }


    // is the randomized queue empty?
    public boolean isEmpty() {
        if (size == 0) {
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
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = (int)(Math.random());
        Item item = items[random];
        items[random] = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(int i) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int r = i + (int)(Math.random() * (size - i));
        Item item = items[r];
        return item;
    }

    public void shuffle(Item[] array) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int)(Math.random() * (n - i));
            Item swap = array[r];
            array[r] = array[i];
            array[i] = swap;
        }

    }

    @SuppressWarnings("unchecked")
    public void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }


}