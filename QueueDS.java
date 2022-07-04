// https://excalidraw.com/#json=uMB2i0Ia7d-GvRTdvY1Kt,-GEnF7Q-0LWW7rKQsj2Apg
// 1. Queue
// 2. circular queue
// 3. Dequeue
// 4. Sliding window using Deque

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDS {
    static class Q {
        private int front;
        private int rear;
        private int size;
        int[] arr; // just declared, not defined
        public Q(int s) {
            this.size = s;
            arr = new int[size];
            front = -1;
            rear = -1;
        }
        public void push(int v) {
            // for handling size limitations
            if (rear == size-1) {
                System.out.print("queue already full");
                return;
            }
            arr[++rear] = v;
            if(front == -1) {
                // queue was empty
                front++;
            }
        }
        public int pop() {
            // to handle size
            if (front == -1) {
                // it means no element present
                return -1;
            }

            int val = arr[front++];
            if (front > rear) {
                // queue has now become empty
                front = rear = -1;
            }
            return val;
        }
        public int front() {
            // to handle size
            if (front == -1) {
                // it means no element present
                return -1;
            }
            return arr[front];
        }
        public boolean isEmpty() {
            if (front > rear || (front == -1 && rear == -1)) {
                return true;
            }
            return false;
        }
    }

    static class CircularQ {
        private int front;
        private int rear;
        private int size;
        int[] arr; // just declared, not defined
        public CircularQ(int s) {
            this.size = s;
            arr = new int[size];
            front = -1; // front points to location where front element is present
            rear = -1; // rear points to location where last element is present
        }
        private boolean isFull() {
            if ((rear+1)%size == front) {
                return true;
            }
            return false;
        }
        public void push(int v) {
            // check if queue is full
            if (isFull()) {
                System.out.print("queue already full");
                return;
            }
            rear = (rear+1)%size;
            arr[rear] = v;
            if (front == -1) {
                // it means previously queue was empty
                front = rear;
            }
        }
        public int pop() {
            if (isEmpty()) {
                System.out.print("queue already empty");
                return -1;
            }
            int val = arr[front];
            front = (front+1)%size;
            if ((rear+1)%size == front) {
                // queue has become empty
                front = rear = -1;
            }
            return val;
        }
        public int front() {
            // to handle size
            if (isEmpty()) {
                // it means no element present
                return -1;
            }
            return arr[front];
        }
        public boolean isEmpty() {
            if(front == -1) {
                return true;
            }
             return false;
        }
    }

    public static void main(String[] args) {
        Q q = new Q(6);
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.print(q.pop());
        System.out.print(q.pop());
        System.out.print(q.pop());
        System.out.print(q.pop());

        Queue<Integer> ourQ = new LinkedList<>();
        ourQ.add(6); // pushing
        ourQ.poll(); // front
        ourQ.remove(); // popping
        ourQ.isEmpty();

        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(6);
        dq.addLast(10);
        dq.removeFirst();
        dq.removeLast();
        dq.isEmpty();
    }
}
