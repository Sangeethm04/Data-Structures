package BST;

public class BST < Key extends Comparable < Key > , Value > {
    private Node root;
    int height;

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

    public Key min() {
        return min(root);
    }

    private Key min(Node x) {
        if (x.left != null) {
            return min(x.left);
        }
        return x.key;
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node x) {
        if (x.right != null) {
            return max(x.right);
        }
        return x.key;
    }

    public Key ceiling(Key k) {
        Node n = ceiling(root, k);
        if (n == null)
            return null;
        return n.key;
    }

    private Node ceiling(Node rt, Key k) {
        if (rt == null)
            return null;
        int cmp = k.compareTo(rt.key);
        if (cmp == 0)
            return rt;
        if (cmp < 0) {
            Node c = ceiling(rt.left, k);
            if (c == null)
                return rt;
            else
                return c;
        } else {
            return ceiling(rt.right, k);
        }

    }

    public Key floor(Key k) {
        Node n = floor(root, k);
        if (n == null)
            return null;
        return n.key;
    }


    public Node floor(Node rt, Key k) {
        if (rt == null) {
            return null;
        }
        int cmp = k.compareTo(rt.key);
        if (cmp == 0) {
            return rt;
        } else if (cmp < 0) {
            return floor(rt.left, k);
        } else if (cmp > 0) {
            Node f = floor(rt.right, k);
            if (f == null) {
                return rt;
            } else {
                return f;
            }
        }
        return null;
    }


    public Key select(int i) {
        Node n = select(root, i);
        if (n == null)
            return null;
        return n.key;
    }

    private Node select(Node rt, int i) {
        if (rt == null)
            return null;
        if (i == size(rt.left) + 1) {
            return rt;
        } else if (i <= size(rt.left)) {
            return select(rt.left, i);
        } else if (i > size(rt.left) + 1) {
            i = i - size(rt.left) - 1;
            return select(rt.right, i);
        }
        return null;
    }

    public int rank(Key k) {
        return rank(root, k);
    }

    private int rank(Node rt, Key k) {
        if (rt == null)
            return 0;
        int cmp = k.compareTo(rt.key);
        if (cmp == 0) {
            return size(rt.left);
        } else if (cmp < 0) {
            return rank(rt.left, k);
        } else {
            return 1 + size(rt.left) + rank(rt.right, k);
        }
    }


    public void printInorder() {
        printInOrder(root);
    }

    private void printInOrder(Node rt) {
        if (rt == null) {
            return;
        }
        printInOrder(rt.left);
        System.out.print(rt.key + " ");
        printInOrder(rt.right);

    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node rt) {
        if (rt == null) {
            return;
        }

        System.out.print(rt.key + " ");
        printPreorder(rt.left);
        printPreorder(rt.right);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(Node rt) {
        if (rt == null) {
            return;
        }
        printPostOrder(rt.left);
        printPostOrder(rt.right);
        System.out.print(rt.key + " ");



    }

}