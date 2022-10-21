// Create an interface called Animal, with the  methods (returning Strings) sound(), eats(), name() and Integer numLegs(). Then create a class that implements Animal. In the client (main) create two instances of your new class, and print out their data members.

package Iterators;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("Dog", "Woof", "Meat", 4);
        Animal a2 = new Animal("Cat", "Meow", "Fish", 4);
        a1.print();
        a2.print();
    }
}
