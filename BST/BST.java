package BST;

public class BST < Key extends Comparable < Key > , Value > {
    private Node root;
    protected int height;


    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n, int height) {
            this.key = key;
            this.val = val;
            this.n = n;
        }

    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftRoot = height(root.left);
        int rightRoot = height(root.right);

        if (leftRoot > rightRoot) {
            return leftRoot;
        } else {
            return rightRoot;
        }
    }

    public String toString() {
        return this.root.key.toString() + this.root.val.toString() + this.root.n + this.height;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right.key);
        else
            return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, Key key, Value val, int height) {
        height += 1;
        System.out.println(height);
        if (x == null) {
            this.height = height;
        }
        if (x == null)
            return new Node(key, val, 1, height);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val, height);
        else if (cmp > 0)
            x.right = put(x.right, key, val, height);
        else
            x.val = val;
        x.n = size(x.left) + size(x.right) + 1;
        return x;

    }

    public static void main(String[] args) {
        BST < Integer, String > tree = new BST < > ();
        tree.put(2, "apple");
        tree.put(1, "banana");
        tree.put(6, "citrus");
        tree.put(3, "citrus");
        tree.put(8, "citrus");
        tree.put(4, "citrus");

        System.out.println("Size: " + tree.size());
        //print out the height of the tree
        System.out.println("Height: " + tree.height);

    }

}