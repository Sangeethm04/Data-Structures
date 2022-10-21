// Create an interface called Animal, with the  methods (returning Strings) sound(), eats(), name() and Integer numLegs(). Then create a class that implements Animal. In the client (main) create two instances of your new class, and print out their data members.

public class Animal {
    private String name;
    private String sound;
    private String eats;
    private int numLegs;
    public Animal(String name, String sound, String eats, int numLegs) {
        this.name = name;
        this.sound = sound;
        this.eats = eats;
        this.numLegs = numLegs;
    }
    public String sound() {
        return sound;
    }
    public String eats() {
        return eats;
    }
    public String name() {
        return name;
    }
    public int numLegs() {
        return numLegs;
    }
    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Sound: " + sound);
        System.out.println("Eats: " + eats);
        System.out.println("Number of legs: " + numLegs);
    }
  
  }