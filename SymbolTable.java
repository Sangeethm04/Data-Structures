import java.util.Iterator;

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


    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        first = new Node();
        first.key = key;
        first.value = val;
        first.next = first;
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
        // TODO Auto-generated method stub
        return null;
    }






}