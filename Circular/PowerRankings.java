package Circular;
import java.util.Iterator;
import java.util.Random;
import java.util.*;

//Create a generic circular linked list class that inserts nodes in a random position.

public class PowerRankings < Item > implements Iterable < Item > {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    // construct an empty deque
    public PowerRankings() {
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
        private Random rand = new Random();

        public ListIterator() {
            if(size() > 1) {
                int random = rand.nextInt(size);
                for(int i = 0; i < random; i++) {
                    current = current.next;
                }
                current.item = current.next.item;
                current.next = current.next.next;
            }
            System.out.println("hello there");
        }

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
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }
    
    // add the item to the front
    public void addNode(Item item) {
        if(isEmpty()) {
            first = new Node();
            first.item = item;
            first.next = first;
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            last.next = first;
        }
        size++;
    }


    // remove and return the item from the front
    public Item removeFirst() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }




}