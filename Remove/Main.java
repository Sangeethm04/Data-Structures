package Remove;

public class Main {
    public static void remove(Stack < String > s, String str) {
        s.remove(str);
    }

    public static void main(String[] args) {
        Stack < String > s = new Stack < String > ();
        s.push("Mary");
        s.push("had");
        s.push("a");
        s.push("little");
        s.push("lamb");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        remove(s, "a");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }


    }

    //create an iterator for the linked list

}