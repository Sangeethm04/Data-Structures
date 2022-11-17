import java.util.Iterator;

public class SymbolTable < Key, Value > implements Iterable < Key > {
    private Node first;
    private int N;

    public SymbolTable() {
        first = null;
        N = 0;
    }

    private class Node {
        Key key;
        Value value;
        Node next;
    }


    public void put(Key key, Value val) {
        
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
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator < Key > iterator() {
        // TODO Auto-generated method stub
        return null;
    }






}