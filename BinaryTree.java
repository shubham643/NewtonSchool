// create -- DONE
// traversal -- DONE in, post, pre, level
// search == DONE
// path -- DONE
// height -- DONE
// diameter -- DONE max distance between any 2 nodes of a binary tree O(n^2), O(n)
// LCA - paths, general
//  1. via printing path of diameter (doesn't work)
//  2. storing path of both nodes in array and then finding last common element ( O(n)) with O(n) space
//  3. Using traversal O(n)
// 21st march -- https://1drv.ms/u/s!ApNLaUHTgtzbkHH2K9Cpl93wwOau?e=tgwSAl
// Array representation of a tree - rarely --> left = 2i+1, right=2i+2, parent = i/2.
// Mirror tree -- DONE
// 1. call recursively and then swap left and right (preorder or postorder)
// 2. Using level order
// level order - (BFS) --> using Queues DONE
// Given 2 traversals, construct tree from them
// 1. pre + in
// 2. post + in
// Balanced BST
// 1. normal bst height is O(n) and all operations (search, insert, delete) O(n)
// 2. balanced bst height is O(logn) and all operations (search, insert, delete) O(logn)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;
    Node(int val) {
        value = val;
        left = right = null;
    }
}

class Height { // now this is pass by reference
    int h;
}

class BinaryTree {
    Node root;
    public BinaryTree() {
        // create binary tree
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
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

    public void preorder() { // O(n)
        Node temp = root;
        preorderUtil(temp);
    }
    private void preorderUtil(Node root) {
        if (root == null) {
            return;
        }
        // self
        System.out.print(root.value);
        // left
        preorderUtil(root.left);
        //right
        preorderUtil(root.right);
    }

    public void postorder() { // O(n)
        Node temp = root;
        postorderUtil(temp);
    }
    private void postorderUtil(Node root) {
        if (root == null) {
            return;
        }
        // left
        postorderUtil(root.left);
        //right
        postorderUtil(root.right);
        // self
        System.out.print(root.value);
    }


    public void search(int val) { // O(n)
        searchUtil(root, val);
    }
    private void searchUtil(Node root, int val) {
        if (root == null) {
            return;
        }
        // any traversal is fine, lets try preorder
        if (root.value == val) {
            System.out.println("Yay, we found that value " + root.value);
            return;
        }
        searchUtil(root.left, val);
        searchUtil(root.right, val);
    }

    public void path(int val) { // O(n)
        ArrayList<Integer> ll = new ArrayList<>();
        pathUtil(root, val, ll);
    }
    private void pathUtil(Node root, int val, ArrayList<Integer> ll) {
        if (root == null) {
            return;
        }
        // preorder
        // do for self in preorder
        ll.add(root.value);
        // any traversal is fine, lets try preorder
        if (root.value == val) {
            System.out.println("Yay, we found that value " + root.value);
            // print the path
            for(int i = 0; i < ll.size(); i++) {
                System.out.print(ll.get(i));
            }
            return;
        }

        // left
        pathUtil(root.left, val, ll);
        //right
        pathUtil(root.right, val, ll);

        // remove last element as we could not find the value
        ll.remove(ll.size()-1);
    }

    public int LCA(int a, int b) {
//        return LCAUtil(root, a, b);
        return LCAOptimized(root, a, b).value;
    }

    private int LCAUtil(Node root, int a, int b) { // time O(n), Space complexity O(n)
        ArrayList<Integer> lFirst = new ArrayList<>();
        ArrayList<Integer> lSecond = new ArrayList<>();

        pathUtil(root, a, lFirst);
        pathUtil(root, b, lSecond);

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < Math.min(lFirst.size(), lSecond.size()); i++) {
            if (lFirst.get(i) != lSecond.get(i)) {
                result = lFirst.get(i-1);
            }
        }
        if (result == Integer.MIN_VALUE) {
            // print the last element of the small list
            result = lFirst.get(Math.min(lFirst.size(), lSecond.size()) - 1);
        }
        return result;
    }

    private Node LCAOptimized(Node root, int a, int b) { // O() ?
        // base conditions
        if (root == null) {
            return null;
        }
        if (root.value == a) {
            return root;
        }
        if (root.value == b) {
            return root;
        }

        Node ll = LCAOptimized(root.left, a, b);
        Node rr = LCAOptimized(root.right, a, b);

        // call for left and right
        if (ll != null && rr != null) {
            return root;
        }
        return ll != null ? ll : rr;
//        if (ll != null) {
//            return ll;
//        }
//        return rr;
    }

    public int height() { // O(n)
//         max(height(left), height(right)) + 1
        return heightUtil(root);
    }

    private int heightUtil(Node root) {
        // base condition
        if (root == null) {
            return 0;
        }
        return Math.max(heightUtil(root.left), heightUtil(root.right)) + 1;
    }

    public int diameter() { // O(n^2)
        // longest path between any 2 nodes in tree
//        return diamterUtil(root);

        Height h = new Height();
        return diamterOptimized(root, h);
    }

    private int diamterUtil(Node root) {
        if (root == null) {
            return 0;
        }
        // left and right height
        int lHeight = heightUtil(root.left);
        int rHeight = heightUtil(root.right);

        // find max diameter in left subtree
        int lMax = diamterUtil(root.left);
        // find max diameter in right subtree
        int rMax = diamterUtil(root.right);

        return Math.max(lMax, Math.max(rMax, 1 + lHeight + rHeight));
    }

    private int diamterOptimized(Node root, Height h) { // h is height from below // O(n) // it assumes both a, b are in the tree
        // base case
        if (root == null) {
            h.h = 0;
            return 0;
        }
        Height lH = new Height();
        Height rH = new Height();
        int leftResult = diamterOptimized(root.left, lH);
        int rightResult = diamterOptimized(root.right, rH);

        // current max height
        h.h = Math.max(lH.h, rH.h) + 1;

        return Math.max(leftResult, Math.max(rightResult, lH.h + rH.h + 1));
    }

    public void mirrorTree() {
        mirrorTreeUtil(root);
    }

    private void mirrorTreeUtil(Node root) {
        if (root == null) {
            return;
        }

        // swap
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTreeUtil(root.left);
        mirrorTreeUtil(root.right);
    }

    public void levelOrderTraversal() { // BFS. O(n)
        Queue<Node> q = new LinkedList<>();
        // add root in q
        q.add(root);
        while(!q.isEmpty()) {
            Node first = q.peek();
            q.remove();
            System.out.print(first.value);
            // push left and right
            if (first.left != null) {
                q.add(first.left);
            }
            if (first.right != null) {
                q.add(first.right);
            }
        }
    }

    static int preIndex = 0;
    public Node createFromInAndPre(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        return createFromInAndPreUtil(inorder, preorder, 0, inorder.size()-1);
    }

    private Node createFromInAndPreUtil(ArrayList<Integer> inorder, ArrayList<Integer> preorder,
                                        int inStart, int inEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }
        Node temp = new Node(preorder.get(preIndex));
        int index = searchIndex(inorder, preorder.get(preIndex), inStart, inEnd);
        preIndex++;
        temp.left = createFromInAndPreUtil(inorder, preorder, inStart, index-1);
        temp.right = createFromInAndPreUtil(inorder, preorder, index+1, inEnd);
        return temp;
    }

    public Node createFromInAndPost(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        return createFromInAndPostUtil(inorder, postorder, 0, inorder.size()-1, 0, postorder.size()-1);
    }

    private Node createFromInAndPostUtil(ArrayList<Integer> inorder, ArrayList<Integer> postorder,
                                         int inStart, int inEnd,
                                         int postStart, int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }
        // last element of post order
        Node temp = new Node(postorder.get(postEnd));
        // find the left part and the right part.
        // find size of left subtree and right subtree
        int index = searchIndex(inorder, postorder.get(postEnd), inStart, inEnd);
        int sizeLeftSubtree = index - inStart;
        int sizeRightSubtree = inEnd - index;
        temp.left = createFromInAndPostUtil(inorder, postorder, inStart, index-1, postStart, postStart + sizeLeftSubtree-1);
        temp.right = createFromInAndPostUtil(inorder, postorder, index+1, inEnd, postStart + sizeLeftSubtree, postEnd);
        return temp;
    }

    private int searchIndex(ArrayList<Integer> inorder, int val, int inStart, int inEnd) {
        for(int i = inStart; i <= inEnd; i++) {
            if (inorder.get(i) == val) {
                return i;
            }
        }
        return -1;
    }

    public void mirrorUsingLevelOrder() { // BFS. O(n)
        Queue<Node> q = new LinkedList<>();
        // add root in q
        q.add(root);
        while(!q.isEmpty()) {
            Node first = q.peek();
            q.remove();
//            System.out.print(first.value);
            // push left and right
            Node temp = first.left;
            first.left = first.right;
            first.right = temp;
            if (first.left != null) {
                q.add(first.left);
            }
            if (first.right != null) {
                q.add(first.right);
            }
        }
    }
}

public class BinaryTreeGeneric {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.inorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.postorder();
        System.out.println();
        tree.search(5);
        System.out.println();
        tree.path(6);
        System.out.println();
        System.out.print("Height of tree is " + tree.height());
        System.out.println();
        System.out.print("Diameter of tree is " + tree.diameter());
        System.out.println();
        System.out.print("LCA of nodes is " + tree.LCA(5, 2));
        System.out.println();
        tree.mirrorTree();
        tree.inorder();
        System.out.println();
        tree.levelOrderTraversal();
        System.out.println();
        tree.mirrorUsingLevelOrder();
        tree.inorder();
        System.out.println();


    }
}
