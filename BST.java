import java.util.ArrayList;
import java.util.List;

// Whiteboard link: https://1drv.ms/u/s!ApNLaUHTgtzbkG36xINFHj0mLYZq?e=dlmYw8

// Given a array, sort the elements of the array. --> with BST?
class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void insert(int a) { // O(n)
        root = insertUtil(root, a);
    }

    private Node insertUtil(Node root, int a) {
        // base case
        if (root == null) {
            Node newNode = new Node(a);
            return newNode;
        }

        if (root.value > a ){
            root.left = insertUtil(root.left, a);
        } else {
            root.right = insertUtil(root.right, a);
        }
        return root;
    }

    // n is number of nodes in tree
    public void inorder() { // O(n)
        Node temp = root;
        inorderUtil(temp);
    }
    private void inorderUtil(Node root) {
        if (root == null) {
            return;
        }
        // left
        inorderUtil(root.left);
        // self
        System.out.print(root.value);
        //right
        inorderUtil(root.right);
    }

    public void delete(int a) { // O(n)
        root = deleteUtil(root, a);
    }

    private Node deleteUtil(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value < val) {
            root.right = deleteUtil(root.right, val);
        } else if (root.value > val) {
            root.left = deleteUtil(root.left, val);
        } else {
            // no child
            if (root.left == null && root.right == null) {
                root = null;
            }
            // 1 child
            else if (root.left == null) {
                root.value = root.right.value;
                root.right = deleteUtil(root.right, root.right.value);
            } else if (root.right == null) {
                root.value = root.left.value;
                root.left = deleteUtil(root.left, root.left.value);
            } else {
                // 2 child
                int smaller = findSmaller(root.left);
                root.value = smaller;
                root.left = deleteUtil(root.left, smaller);
            }
        }
        return root;
    }

    private int findSmaller(Node root) {
        while(root.right != null) {
            root = root.right;
        }
        return root.value;
    }
}

public class BinarySearchTree {

    // BST - Binary search tree
    // left node < root node
    // right node > root node
    // max 2 child of a node

    // inorder of BST is always sorted

    // insert in BST
    // delete in BSt

    public static void main(String[] args) {
        BST root = new BST();
        root.insert(5);
        root.insert(4);
        root.insert(8);
        root.insert(7);
        root.insert(6);
        root.insert(10);
        root.insert(9);
        root.inorder();
        System.out.println();
        root.delete(4);
        System.out.println("After 4");
        root.inorder();
        System.out.println();

        root.delete(10);
        System.out.println("After 10");
        root.inorder();
        System.out.println();

        root.delete(8);
        System.out.println("After 8");
        root.inorder();
        System.out.println();
//
//        List<Integer> ll = new ArrayList<>();
//        ll.add(5);
//        ll.add(4);
//        ll.add(8);
//        ll.add(7);
//        ll.add(6);
//
//        // sort ll
//        BST root1 = new BST();
//        for(int i = 0; i < ll.size(); i++) {
//            root1.insert(ll.get(i)); // O(n) * O(n_ == O(n^2)
//        }
//        root1.inorder(); // O(n)

    }
}
