pack
public class Main {
    public static void main(String[] args) {
      RandomizedQueue <String> rq = new RandomizedQueue <String>();

  
      rq.enqueue("1");
      rq.enqueue("2");
      rq.enqueue("3");
      rq.enqueue("4");
      rq.enqueue("5");
  
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
  