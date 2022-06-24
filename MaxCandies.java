import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
        // Your code here
        // int n;
        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        // int[][] mat = new int[2][n];
        // for(int i =0; i < 2; i++) {
        // 	for(int j = 0; j < n; j++) {
        // 		mat[i][j] = sc.nextInt();
        // 	}
        // }
        // int[][] res = new int[2][n];
        // res[0][0] = mat[0][0];

        // for(int i = 1; i < n; i++) { // fill first row
        // 	res[0][i] = mat[0][i] + res[0][i-1];// self + left result
        // }

        // // fill second row
        // mat[1][0] = mat[0][0] + mat[1][0]; // top + self

        // // fill rest cells in 2nd row
        // for(int i = 1; i < n; i++) {
        // 	res[1][i] = mat[1][i] + maxm(res[0][i], res[1][i-1]); // self + max(top result, left result)
        // }

        // System.out.print(res[1][n-1]);

        // without extra space

        // int n;
        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        // int[][] mat = new int[2][n];
        // for(int i =0; i < 2; i++) {
        // 	for(int j = 0; j < n; j++) {
        // 		mat[i][j] = sc.nextInt();
        // 	}
        // }

        // for(int i = 1; i < n; i++) { // fill first row
        // 	mat[0][i] = mat[0][i] + mat[0][i-1];// self + left result
        // }

        // // fill second row
        // mat[1][0] = mat[0][0] + mat[1][0]; // top + self

        // // fill rest cells in 2nd row
        // for(int i = 1; i < n; i++) {
        // 	mat[1][i] = mat[1][i] + maxm(mat[0][i], mat[1][i-1]); // self + max(top result, left result)
        // }
        // System.out.print(mat[1][n-1]);

        // with recursion

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] mat = new int[2][n];
        for(int i =0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < n; i++) { // fill first row
            mat[0][i] = mat[0][i] + mat[0][i-1];// self + left result
        }

        mat[1][0] = mat[1][0] + mat[0][0];

        System.out.println(solve(mat, 1, n-1));
    }

    private static int solve(int[][] mat, int i, int j) {
        // we want to solve for (i,j)
        // base condition
        // if it is first row then return itself or if it is first column then also return itself
        if (i == 0 || j == 0) {
            return mat[i][j];
        }

        return mat[i][j] + maxm(solve(mat, i-1, j), solve(mat, i, j-1));
        //    self         maxm(top, left)
    }

    private static int maxm(int a, int b) {
        return a > b ? a : b;
    }
}


// 5
// 1 3 5 6 2
// 2 4 8 4 2

// 3
// 1 3 8
// 4 1 1

// ans = 1+3+8+1=13

// Greedy approach -> 1 + 4 + 1 + 1 = 7 local best solution

// top left -> bottom right

// x x x x 22
// x x x 20 25 (3 of self)

// Result(i,j) = mat[i][j] + max(Result(i-1,j), Result(i, j-1))
// // 				self			top				left

// // 1 4 9 15 17
// // 3 8 17 21 23


// res matrix
// 1 4 9

// result matrix below
// // 1 4 9 15 17
// // 3 8 17 21 23

// path-> (1,1)<-(1,2)<-(1,3)<-(2,3)<-(2,4)<-(2,5)

// 4(self) + max (4,3), 4 is top, 3 is left = 8 --> right, down
