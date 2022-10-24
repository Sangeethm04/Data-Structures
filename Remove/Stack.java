package Remove;
import java.util.Iterator;

//create an iterator for the linked list



public class Stack < Item > implements Iterable < Item > {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

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
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
    public void remove(Item item) {
        Node current = first;
        Node previous = null;
        while (current != null) {
            if (current.item.equals(item)) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    first = current.next;
                }
            }
            previous = current;
            current = current.next;
        }
    }
}