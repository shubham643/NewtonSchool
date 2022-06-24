import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonsterHunt {

    static class Pair {
        int index;
        int health;

        public Pair(int i, int h) {
            index = i;
            health = h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();

        Queue<Pair> q = new LinkedList<>();
        // read input and put in q
        for(int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Pair pp = new Pair(i, val); // input k has 0 based indexing
            // push pair in q
            q.add(pp);
        }

        int count = 0;
        while(true) {
            count++;
            // run loop till kth index becomes 0

            // take front element of q out
            Pair front = q.remove();
            // if its index == k and health == 1,
            if (front.index == k && front.health == 1) {
                break;
            }
            front.health = front.health-1;
            // push front elemtn to back
            if (front.health != 0) {
                q.add(front);
            }
        }
        System.out.print(count);
    }
}
//Queue -> FIFO
//n = 3, k = 2
// 1 3 2
     //   (index, health)
//Queue
// count = 0
// (1,1) (2,3) (3,2)

//count = 1
// (2,3) (3,2)

// count = 2
// (3,2) (2,2)

// count = 3
// (2,2) (3,1)

// count = 4
// (3,1) (2,1)
