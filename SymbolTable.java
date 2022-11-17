import java.util.Iterator;

public class SymbolTable < Key, Value > implements Iterable < Key> {
    private Node first;
    private int N;

    public SymbolTable() {

    }

    private class Node {
        Key key;
        Value value;
        Node next;
    }


    public void put(String key, Double value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public Value get(Key key) {
        Node temp = first;
      while(!temp.key.equals(key)) {
        temp = temp.next;
      }
      return temp.value;
    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {

    }

    public boolean isEmpty() {

    }

    public int size() {

    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        return null;
    }




}