package October;
import java.util.Iterator;

public class Deque < Item > implements Iterable < Item > {
    public Node first;
    public Node last;
    public int size;

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

    public class ListIterator implements Iterator < Item > {
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
    public void addFirst(Item item) {
        Node oldfirst = first;
        if(size == 0) {
            first = new Node();
            first.item = item;
            first.next = last;
            first.previous = null;
            last = first;
        } else {
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            first.previous = null;
            oldfirst.previous = first;
        }
        size++;
        
    }

    // add the item to the back
    public void addLast(Item item) {
        Node oldLast = last;
        if(size == 0) {
            last.item = item;
            last.next = null;
            last.previous = first;
            first = last;
        } else {
            last = new Node();
            last.item = item;
            last.previous = oldLast;
            last.next = null;
            oldLast.next = last;
        }
        size++;
        
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item = first.item;
        first = first.next;
        return item;    
    }

    // remove and return the item from the back
    public Item removeLast() {
        Node oldLast = last;
        Item item = oldLast.item;
        oldLast.previous.next = null;
        last = oldLast.previous;
        return item;
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque < Integer > deque = new Deque < Integer > ();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println("Last item: " + deque.removeLast());
        //deque.removeLast();




        //print out the deque
        for (Integer i: deque) {
            System.out.println(i);
        }
    }
}