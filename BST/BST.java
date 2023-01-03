package BST;

public class BST < Key extends Comparable < Key > , Value > {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;
        private int height;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.count = n;
        }

    }

    public int height() {
        return height(root);
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftRoot = height(root.left);
        System.out.println("left: " + leftRoot + " key: " + root.key + " value: " + root.val);
        int rightRoot = height(root.right);
        System.out.println("right: "+rightRoot + " key: " + root.key + " value: " + root.val);

        if (leftRoot > rightRoot) {
            return (leftRoot + 1);
        } else {
            return (rightRoot + 1);
        }
    }

    public int height2() {
        return height2(root);
    }

    public int height2(Node root) {
        if (root == null) {
            return 0;
        }

       

    }


    public String toString() {
        return "Key: " + this.root.key.toString() + " Value: " + this.root.val.toString() + " Height: " + this.height();
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.count;
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
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.count = size(x.left) + size(x.right) + 1;
        return x;

    }

}