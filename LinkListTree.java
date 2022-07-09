// https://excalidraw.com/#json=kBu7m3pvqNEyCTOmCfCXB,vnW4KRo0oBPdZFmPy3MMaA

//            Array                             Link List
//1. Size fixed- can't extend,        1. flexible size
//            nor we can release
//2. contiguous memory allocation     2. non contiguous memory, accessing index i is O(i)
//    - accessing index i O(1)
// 3. faster due to better caching    3. slower as slower caching process
// 4. need continuous memory only     4. doesn't need continous memory
// 5. can go back and forth           5. only possible in doubly link list

// When to use what
// link list implementation
// link list java library


import java.util.ArrayList;
import java.util.List;

public class LinkList {
    static class Student{
        String name;
        int age;
    }

    static class DLL { // double link list
        int val;
        Node left;
        Node right;
        public DLL(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class NodeBT { // binary tree
        int val;
        Node left;
        Node right;
        public NodeBT(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // tree with n children
    static class NaryTree { // binary tree
        int val;
        // maximum n children
        Node[] children;
        public NaryTree(int val, int n) {
            this.val = val;
            children = new Node[n]; // children[0] points to another child node
        }
    }

    static class Node {
        // content and next node
        int val; // of any type, like Student val;
        Node next; // reference to next node
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node ll = null;
        // add new element 5;
        addElement(ll, 5);
        addElement(ll, 10);
        addElement(ll, 15);
        traverse(ll);
        int val = getElementAtPosition(ll, 2); // 1 based indexing
        System.out.println(val);
        delete(10, ll);

        // java library
        List<Student> linkList = new ArrayList<>();
        linkList.add(new Student()); // add at last
        linkList.size();
        linkList.get(2); // O(n)
        Student s = new Student();
        linkList.contains(s); // check if s is present in list or not.


        String ss = "Shubham";
        String substring = ss.substring(0, 2); // substring = Sh
    }

    private static void traverse(Node ll) {
        Node temp = ll;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static void delete(int val, Node ll) {
        // we want to delete element having value = val
        // 1. if val is first node
        // 2. if val is last node
        // 3. if val is inbetween node
        // 4. if ll is empty
        // 5. if val is not present in ll

        if (ll == null) { // case 4
            return;
        }
        if (ll.val == val) { // case 1
            ll = ll.next;
        }
        // traverse to find the node
        Node temp = ll;
        while(temp != null && temp.next != null && temp.next.val != val) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) { // statement 1
            return;
        }
//        if (temp.next == null || temp == null) { // statement 2 is incorrect
//            return;
//        }
        // we have found the node to be deleted and temp is previous node
        temp.next = temp.next.next; // handle case 2,3
    }

    private static int getElementAtPosition(Node ll, int i) {
        int count = 0;
        Node temp = ll;
        while (temp != null && count < i) { // temp!=null is required so that we don't go outside the list
            count++;
            if (count == i) {
                return temp.val;
            }
            temp = temp.next;
        }
        return -1; // only if i > size of list
    }

    private static void addElement(Node ll, int val) {
        // create a new node
        Node newNode = new Node(val); // allocating memory
        if (ll == null) {
            ll = newNode;
        } else {
            // iterate till the current last node of list
            // put its next as newNode
            Node temp = ll;
            // move temp till the last node
            while(temp.next != null) {
                temp = temp.next;
            }
            // now the next of temp is null, which means temp is last node
            temp.next = newNode;
        }
    }
}
