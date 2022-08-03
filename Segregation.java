// https://excalidraw.com/#json=9w7sH8yLERLkqRXWb62XE,5rJzGKmmeOxcWWYSk3gVQA
public class Segragation {

    private static class Node {
        int data;
        Node next;
        public Node(int d){
            data=d;
        }
    };

    static Node segregation (Node head)
    {
        // Complete this function
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node headEven = even; // this will be needed at the end to connect both the lists

        while(odd != null && even != null) {
            odd.next = odd.next.next;
            if (even.next != null)
                even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        // now we have 2 linked lists odd and even, we just need to link the last node of odd to first node of even
        Node temp = lastOfOdd(head); // temp is the last node of odd list.
        temp.next = headEven;
        return head;
    }

    private static Node lastOfOdd(Node odd) {
        Node temp = odd;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = null;
        Node output = segregation(head);
        while(output != null) {
            System.out.println(output.data);
            output = output.next;
        }
        // edge case that we need to test - even list size, odd list size, empty list, 1 size, 2 size
    }
}

// 2 1
