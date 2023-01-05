package BST;

class Main {
    public static void main(String[] args) {
        BST < Integer, String > tree = new BST < > ();
        tree.put(1, "apple");
        tree.put(2, "banana");
        tree.put(4, "citrus");
        tree.put(3, "citrus");
        tree.put(5, "citrus");


        System.out.println(tree.size());
        //print out the height of the tree
        System.out.println(tree.height);
    }
}