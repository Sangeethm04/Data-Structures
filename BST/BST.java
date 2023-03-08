// public class BST < Key extends Comparable < Key > , Value > {
//     private static final boolean RED = true;
//     private static final boolean BLACK = false;
//     private Node root;
//     private int h; // height of tree

//     private class Node {

//         private Key key;
//         private Value val;
//         private Node left, right; //left and right subtrees
//         private int sz; //how many nodes in this tree/subtree
//         boolean color;

//         public Node(Key key, Value val, int sz, boolean color) {

//             this.key = key;
//             this.val = val;
//             this.color = color;
//             this.sz = sz;
//         }

//         public Key getKey() {
//             return key;
//         }

//         public void printBST() {
//             if (this.left != null) {
//                 left.printBST();
//             }
//             System.out.println(this.key + " ");
//             if (this.right != null) {
//                 right.printBST();
//             }


//         }

//         public int height() {

//             int leftHeight = 0;
//             int rightHeight = 0;
//             if (this.left != null) {
//                 leftHeight = this.left.height();
//             }

//             if (this.right != null)
//                 rightHeight = this.right.height();


//             if (leftHeight > rightHeight)
//                 return 1 + leftHeight;
//             else return 1 + rightHeight;

//         }




//         public void printInorder() {
//             if (this.left != null) {
//                 left.printInorder();
//             }
//             System.out.print(this.key); //the root
//             if (this.right != null) {
//                 right.printInorder();
//             }
//         }
//         public void printPreorder() {
//             System.out.print(this.key);
//             if (this.left != null) {
//                 left.printPreorder();
//             }
//             if (this.right != null) {
//                 right.printPreorder();
//             }
//         }
//         public void printPostorder() {

//             if (this.left != null) {
//                 left.printPostorder();
//             }
//             if (this.right != null) {
//                 right.printPostorder();
//             }
//             System.out.print(this.key);
//         }


//         public Node getRoot() {
//             return root;
//         }
//         private boolean isRed(Node x) {
//             if (x == null) return false;
//             return x.color == RED;
//         }
//         public int size() {
//             return size(root);
//         }

//         private int size(Node x) {
//             if (x == null)
//                 return 0;
//             else
//                 return x.sz;
//         }

//         public Value get(Key key) {

//             return get(root, key);
//         }

//         private Value get(Node x, Key key) {

//             if (x == null)
//                 return null;

//             int cmp = key.compareTo(x.key);
//             if (cmp < 0)
//                 return get(x.left, key);
//             else if (cmp > 0)
//                 return get(x.right, key);
//             else
//                 return x.val;
//         }

//         public void put(Key key, Value val) {


//             root = put(root, key, val, 0);

//         }

//         private Node put(Node x, Key key, Value val, int ht) {
//             ht = ht + 1;
//             if (x == null) { //empty tree
//                 if (ht > this.h) this.h = ht; // ses global height variable
//                 return new Node(key, val, 1, RED);
//             }
//             int cmp = key.compareTo(x.key);
//             if (cmp < 0)
//                 x.left = put(x.left, key, val, ht);
//             else if (cmp > 0)
//                 x.right = put(x.right, key, val, ht);
//             else
//                 x.val = val;
//             x.sz = size(x.left) + size(x.right) + 1;
//             if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
//             if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
//             if (isRed(x.left) && isRed(x.right)) flipColors(x);
//             return x;
//         }

//         public int height() {

//             return root.height();
//         }
//         public int height2() {
//             return h;
//         }
//         public Key select(int k) {
//             if (k <= 0 || k > size()) throw new IllegalArgumentException();
//             Node x = select(root, k);
//             return x.key;
//         }
//         public Node select(Node x, int k) {
//             if (x == null) return null;
//             int leftTreeSize = size(x.left);
//             if (k == (leftTreeSize + 1)) return x;
//             if (k <= leftTreeSize) return (select(x.left, k));
//             else return select(x.right, (k - leftTreeSize - 1));

//         }
//         public Key ceiling(Key k) {
//             Node n = ceiling(root, k);
//             if (n == null) return null;
//             return n.key;
//         }
//         private Node ceiling(Node rt, Key k) {
//             if (rt == null) return null;
//             int cmp = k.compareTo(rt.getKey());
//             if (cmp == 0) return rt;
//             if (cmp < 0) {
//                 Node c = ceiling(rt.left, k);
//                 if (c == null) return rt;
//                 else return c;
//             } else {
//                 return ceiling(rt.right, k);
//             }
//         }
//         public Key floor(Key k) {
//             Node n = floor(root, k);
//             if (n == null) return null;
//             return n.key;
//         }
//         private Node floor(Node root, Key k) {
//             if (root == null) return null;
//             int cmp = k.compareTo(root.key);
//             if (cmp == 0) return root;
//             if (cmp > 0) {
//                 Node f = floor(root.right, k);
//                 if (f == null) return root;
//                 else return f;
//             } else return floor(root.left, k);
//         }

//         public int rank(Key k) {
//             return rank(root, k);
//         }
//         private int rank(Node rt, Key k) {
//             if (rt == null) return 0;
//             int cmp = k.compareTo(rt.getKey());
//             //We found it
//             if (cmp == 0) return size(rt.left);
//             if (cmp < 0) return rank(rt.left, k);
//             else return 1 + size(rt.left) + rank(rt.right, k);
//         }
//         public Key min() {
//             if (root == null) return null;
//             return min(root);
//         }
//         private Key min(Node root) {
//             if (root.left != null)
//                 return min(root.left);
//             return root.getKey();
//         }
//         public void printInorder() {
//             root.printInorder();
//         }
//         public void printPreorder() {
//             root.printPreorder();
//         }
//         public void printPostorder() {
//             root.printPostorder();
//         }

//         private Node rotateLeft(Node oldRoot) {
//             Node newRoot = oldRoot.right;
//             oldRoot.right = newRoot.left;
//             newRoot.left = oldRoot;
//             newRoot.color = oldRoot.color;
//             oldRoot.color = RED;
//             return newRoot;
//         }

//         private Node rotateRight(Node oldRoot) {
//             Node newRoot = oldRoot.left;
//             oldRoot.left = newRoot.right;
//             newRoot.right = oldRoot;
//             newRoot.color = oldRoot.color;
//             oldRoot.color = RED;
//             return newRoot;
//         }
//         private void flipColors(Node flippedRoot) {
//             flippedRoot.color = RED;
//             flippedRoot.left.color = BLACK;
//             flippedRoot.right.color = BLACK;
//         }
//         private Node moveRedLeft(Node h) { //assum h is red and h.left and h.left.left is black, make h.left or one of it's children red
//             flipColors(h);
//             if (isRed(h.right.left)) //Is the sibling a 3 node
//             {
//                 h.right = rotateRight(h.right);
//                 h = rotateLeft(h);
//                 flipColors(h);
//             }
//             return h;
//         }
//         public void deleteMin() {
//             if (!isRed(root.left) && !isRed(root.right))
//                 root.color = RED;
//             root = deleteMin(root);
//             if (!isEmpty()) root.color = BLACK;
//         }

//     }

// }