package BST;

class Main {
    public static void main(String[] args) {
        BST < Integer, String > tree = new BST < > ();
        tree.put(25, "apple");
        tree.put(15, "banana");
        tree.put(50, "citrus");
        tree.put(10, "citrus");
        tree.put(4, "apple");
        tree.put(12, "banana");
        tree.put(22, "citrus");
        tree.put(18, "citrus");
        tree.put(24, "apple");
        tree.put(50, "banana");
        tree.put(35, "citrus");
        tree.put(31, "citrus");
        tree.put(44, "banana");
        tree.put(70, "citrus");
        tree.put(66, "citrus");
        tree.put(90, "citrus");

        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height);
        System.out.println("Max: " + tree.max());
        System.out.println("Floor: " + tree.floor(2));
        System.out.println("Rank: " + tree.rank(8));
        System.out.println("Select: " + tree.select(4));
        System.out.println();
        tree.printInorder();
        System.out.println();
        tree.printPreorder();
        System.out.println();
        tree.printPostOrder();

    }
}