package BST;

class Main {
    public static void main(String[] args) {
        BST < Integer, String > tree = new BST < > ();
        tree.put(1, "apple");
        tree.put(9, "banana");
        tree.put(3, "citrus");
        tree.put(8, "citrus");

        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height);
        System.out.println("Max: " + tree.max());
        System.out.println("Floor: " + tree.floor(2));
        System.out.println("Rank: " + tree.rank(8));
        System.out.println("Select: " + tree.select(4));
        tree.printInorder();

    }
}