
// definition of a node in binary tree
class Node {
    public int value;
    public Node left;
    public Node right;
}

// in l, s, r
// pre s, l, r
// post l, r, s

public class BinaryTree {
    // only root node is enough to access whole tree
    Node root;

    private static void inorder(Node root) {
        // base
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }

    private static void preorder(Node root) {
        // base
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        inorder(root.left);

        inorder(root.right);
    }

    private static void postorder(Node root) {
        // base
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) {

    }

}
