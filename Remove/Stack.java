// Create a generic linked list implementation of either a queue or stack. Implement it for the class String. Create a function called remove() that takes a linked list and a string and removes all of the nodes in the list with their item=string. What is the best runtime for remove()?

package Remove;
import java.util.Iterator;

//create an iterator for the linked list



public class Stack < Item > {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
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