package Circular;
import java.util.Iterator;
import java.util.Random;

public class PowerRankings < Item > implements Iterable < Item > {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node nextNode;
    }

    // construct an empty deque
    public PowerRankings() {
        first = null;
        size = 0;
    }
    

    // return an iterator over items in order from front to back
    public Iterator < Item > iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator < Item > {
        private Random r = new Random();
        private Node current = first;
        int iteratredNodes = 0;
        ListIterator() {
            if (size() > 0);
            int position = r.nextInt(size());
            System.out.println(position);
            for (int j = 0; j <= position; j++) {
                current = current.next;
            }
        }
        private Node current = first;


        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.nextNode;
            return item;
        }

        public void remove() {

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
        Node oldfirst = first;
        first = new Node();
        last.nextNode = first;
        first.item = item;
        first.nextNode = oldfirst;
    }


    // remove and return the item from the front
    public Item removeFirst() {
        Item item = first.item;
        first = first.nextNode;
        return item;
    }


}