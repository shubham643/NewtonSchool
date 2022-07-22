import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Buytickets {

    public static class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static void main (String[] args) {
//        solution1(); // O(sum of all elements)
        solutionWithPair(); // O(sum of all elements)
        solutionWithBestApproach(); // O(n)
    }
    private static void solution1() {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // input reading is done
        int result = 0;
        Queue<Integer> q = new LinkedList<>(); // in queue we put indexes of array, not their actual value
        for(int i = 0; i < n; i++) {
            q.add(i); // putting indexes
        }
        while(!q.isEmpty()) {
            result++;
            int index = q.poll(); // extract first element
            // reduce its count in array
            arr[index]--;
            // put element back in queue if new value is non zero
            if (arr[index] == 0 && index == k) {
                // we are done now.
                break;
            }
            if (arr[index] != 0) {
                q.add(index);
            }
        }
        System.out.println(result);
    }

    private static void solutionWithPair() {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // input reading is done
        int result = 0;
        Queue<Pair> q = new LinkedList<>(); // q of pairs (index, value)
        for(int i = 0; i < n; i++) {
            Pair pp = new Pair(i, arr[i]);
            q.add(pp);
        }
        while(!q.isEmpty()) {
            result++;
            // extract front pair
            Pair front = q.poll();
            front.val--; // reduce its value
            if (front.index == k && front.val == 0) {
                // we are done now
                break;
            } else if (front.val != 0) {
                // add the element back of queue
                q.add(front);
            }
        }
        System.out.println(result);
    }

    private static void solutionWithBestApproach() {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // input reading is done
        int res = 0;
        // for elements till k, max value is arr[k]
        for(int i = 0; i <= k ;i++) {
            res += Math.min(arr[k], arr[i]);
        }
        // for elements after k, max value is arr[k]-1
        for(int i = k+1; i < n; i++) {
            res += Math.min(arr[k]-1, arr[i]);
        }
        System.out.println(res);
    }
}
