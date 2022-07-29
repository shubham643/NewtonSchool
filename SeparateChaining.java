import java.util.ArrayList;
import java.util.Scanner;

public class SeparateChaining {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-- != 0) {
            int hashsize = sc.nextInt();
            int arrSize = sc.nextInt();

            int[] arr = new int[hashsize];
            ArrayList<Integer>[] hashtable = new ArrayList[hashsize]; // hash table
            for(int i = 0; i < arrSize; i++) {
                int num = sc.nextInt();
                int index = num%hashsize;
                if (hashtable[index] == null) {
                    hashtable[index] = new ArrayList<>();
                }
                hashtable[index].add(num);
            }
            for(int i = 0; i < hashsize; i++) {
                if (hashtable[i] != null && !hashtable[i].isEmpty()) {
                    System.out.print(i + "->");
                    // print the list now
                    for(int j = 0; j < hashtable[i].size(); j++) {
                        System.out.print(hashtable[i].get(j));
                    }
                    System.out.println();
                }
            }
            System.out.println("~");
        }
    }
}
