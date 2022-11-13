package Circular;
import java.util.Random;
import java.util.*;

import java.util.Iterator;

public class PowerRankings < Item > implements Iterable < Item >{

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new PowerRankingsIterator();
    }

    private class PowerRankingsIterator implements Iterator < Item > {



        @SuppressWarnings("unchecked")
        public PowerRankingsIterator() {
          
        }

        public boolean hasNext() {
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[i++];
        }
    }

    

    
}
