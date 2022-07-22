import java.util.Scanner;

public class HousePaint {
    public static class Triplet {
        int costRed;
        int costGreen;
        int costBlue;
        public Triplet(int costRed, int costGreen, int costBlue) {
            this.costRed = costRed;
            this.costGreen = costGreen;
            this.costBlue = costBlue;
        }
    }
    public static void main(String[] args) {
//        solution1(); // time: O(3*n), space O(3*n + 3*n)
        solution2(); // time: O(3*n), space O(3*n + 3*n)
        solution3(); // time: O(3*n), space O(3*n)
    }
    private static void solution1() {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Triplet[] arr = new Triplet[n];
        for(int i = 0; i < n; i++) {
            int red = sc.nextInt();
            int green = sc.nextInt();
            int blue = sc.nextInt();
            Triplet tr = new Triplet(red, green, blue);
            arr[i] = tr;
        }

        // input reading done
        Triplet[] result = new Triplet[n];
        result[0] = arr[0];
        for(int i = 1; i < n; i++) {
            // red
            int costRed = arr[i].costRed + Math.min(arr[i-1].costGreen, arr[i-1].costBlue);
            // green
            int costGreen = arr[i].costGreen + Math.min(arr[i-1].costRed, arr[i-1].costBlue);
            // blue
            int costBlue = arr[i].costBlue + Math.min(arr[i-1].costGreen, arr[i-1].costRed);
            Triplet tr = new Triplet(costRed, costGreen, costBlue);
            result[i] = tr;
        }
        // print the min of arr[n-1]
        System.out.println(Math.min(result[n-1].costGreen, Math.min(result[n-1].costRed, result[n-1].costBlue)));
    }

    private static void solution2() {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[3][n];
        for(int i = 0; i < n; i++) {
            arr[0][i] = sc.nextInt(); // red
            arr[1][i] = sc.nextInt(); // green
            arr[2][i] = sc.nextInt(); // blue
        }

        // input reading done
        int[][] res = new int[3][n];
        res[0][0] = arr[0][0];
        res[1][0] = arr[1][0];
        res[2][0] = arr[2][0];
        for(int i = 1; i < n; i++) {
            // red
            res[0][i] = arr[0][i] + Math.min(res[1][i-1], res[2][i-1]);
            // green
            res[1][i] = arr[1][i] + Math.min(res[0][i-1], res[2][i-1]);
            // blue
            res[2][i] = arr[2][i] + Math.min(res[0][i-1], res[1][i-1]);
        }
        System.out.println(Math.min(res[0][n-1], Math.min(res[1][n-1], res[2][n-1])));
    }

    private static void solution3() {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[3][n];
        for(int i = 0; i < n; i++) {
            arr[0][i] = sc.nextInt(); // red
            arr[1][i] = sc.nextInt(); // green
            arr[2][i] = sc.nextInt(); // blue
        }

        // input reading done
        for(int i = 1; i < n; i++) {
            // red
            arr[0][i] = arr[0][i] + Math.min(arr[1][i-1], arr[2][i-1]);
            // green
            arr[1][i] = arr[1][i] + Math.min(arr[0][i-1], arr[2][i-1]);
            // blue
            arr[2][i] = arr[2][i] + Math.min(arr[0][i-1], arr[1][i-1]);
        }
        System.out.println(Math.min(arr[0][n-1], Math.min(arr[1][n-1], arr[2][n-1])));
    }
}
