package SymbolTable;
import java.util.Iterator;
import java.util.*;

public class SymbolTable < Key, Value > implements Iterable < Key > {
    private Node first;
    private int size;

    public SymbolTable() {
        first = null;
        size = 0;
    }

    private class Node {
        Key key;
        Value value;
        Node next;
    }

    private class SymbolTableIterator implements Iterator < Key > {

        int current = 0;
        Node currentNode;

        public SymbolTableIterator() {
            currentNode = first;

        }

        public Key next() {
            Node original = currentNode;
            currentNode = original.next;
            current++;
            return original.key;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove called");
        }


        public boolean hasNext() {
            if (current < size()) {
                return true;
            } else {
                return false;
            }
        }


    }


    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        if (isEmpty()) {
            first = new Node();
            first.key = key;
            first.value = val;
            first.next = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.key = key;
            first.value = val;
            first.next = oldFirst;
        }
        size++;
    }

    public Value get(Key key) {
        Node temp = first;
        while (!temp.key.equals(key)) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator < Key > iterator() {
        return new SymbolTableIterator();
    }
}