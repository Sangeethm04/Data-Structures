public class Main {
    public static void main(String[] args) {
   RandomizedQueue<String> rq = new RandomizedQueue<String>();
  
      rq.enqueue("Mary");
      rq.enqueue("had");
      rq.enqueue("a");
      rq.enqueue("little");
      rq.enqueue("lamb");
  
      for (String s: rq) {
        if (s != null)
          System.out.println(s);
      }
      for (String s2: rq) {
        if (s2 != null)
          System.out.println(s2);
      }
    }
  }
  