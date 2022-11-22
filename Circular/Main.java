package Circular;


public class Main {
    // unit testing (required)
    public static void main(String[] args) {
        PowerRankings < String > q = new PowerRankings < String > ();
        q.addNode("1");
        q.addNode("2");
        q.addNode("3");
        q.addNode("4");
        q.addNode("5");
        q.addNode("6");
        q.addNode("7");
        q.addNode("8");
        q.addNode("9");
        q.addNode("10");

        //print out the deque
        for (String i: q) {
            System.out.print(i + " ");

        }
       
    }
}