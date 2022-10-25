package October;
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

        public remove() }{

        }
    }

    // is the deque empty?
    public boolean isEmpty() {

    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    // add the item to the back
    public void addLast(Item item) {
        if(size == 0) {
            first = newNode();
            

        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        
    }

    // remove and return the item from the back
    public Item removeLast() {

    }

    // return an iterator over items in order from front to back

    // unit testing (required)
    public static void main(String[] args) {

    }
}