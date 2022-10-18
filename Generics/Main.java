package Generics;

public class Main {
    public static void main(String[] args) {
        Print3 < String > p1 = new Print3 < String > ("Dog");
        Print3 < Integer > p2 = new Print3 < Integer > (5);
        p2.print3();
        p1.print3();
    }
}