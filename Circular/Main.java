package Circular;
import java.util.Random;
import java.util.*;

public class Main {
       // unit testing (required)
       public static void main(String[] args) {
        PowerRankings < Integer > q = new PowerRankings < Integer > ();
        q.addNode(1);
        q.addNode(2);
        q.addNode(3);
        q.addNode(4);
        q.addNode(5);
        q.addNode(6);
        q.addNode(7);
        q.addNode(8);
        q.addNode(9);
        q.addNode(10);

        //print out the deque
        for (Integer i: q) {
            System.out.println(i);
        }
    }
}
