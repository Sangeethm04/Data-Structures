import java.util.Iterator;
import java.util.*;

public class Deque < Item > implements Iterable < Item > {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // return an iterator over items in order from front to back
    public Iterator < Item > iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator < Item > {
        private Node current = first;


        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove called");
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (size == 1) {
            return true;
        } else {
            return false;
        }
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null;get it right next time");
        }
        Node oldLast = last;
        last = new Node();
        last.previous = oldLast;
        last.next = null;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;
        first = first.next;
        size--;
        return item;

    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = last.item;
        last = last.previous;
        size--;
        return item;
    }


    // unit testing (required)
    public static void main(String[] args) {
        //print deque
        Deque < String > deque = new Deque < String > ();
        deque.addFirst("hello");
        deque.addFirst("world");
        deque.addFirst("sdfasd");
        deque.addFirst("asdf");
        for (String s: deque) {
            System.out.println(s);
        }
    }
}