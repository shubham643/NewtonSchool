import java.util.Scanner;

public class MatrixAgain {
    public static void main(String[] args) {
        int m;
        int n;
        // m*n matrix, m rows, n columns
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        int[][] mat = new int[m][n]; // m rows, n colmns
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] results = new int[m][n];
        results[0][0] = mat[0][0];
        // fill 0th row n columns
        for(int i = 1; i < n; i++) {
            results[0][i] = mat[0][i] + results[0][i-1];
                     //       self    +   result of left
        }
        // fill 0th column, m rows
        for(int i = 1; i < m; i++) {
            results[i][0] = mat[i][0] + results[i-1][0];
            //       self    +   result of up
        }

        // do processing
//        int answer = solve(mat, m, n, results, m-1, n-1);
//        System.out.println(answer);

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                results[i][j] = mat[i][j] + maxm(results[i-1][j], results[i][j-1]);
            }
        }
        System.out.println(results[m-1][n-1]);
    }

    private static int solve(int[][] mat, int m, int n, int[][] results, int i, int j) {
        // base condition
        if (i == 0 || j == 0) {
            // either first row or first column
            return results[i][j];
        }

        results[i][j] = mat[i][j] + maxm(solve(mat, m, n, results, i-1, j), solve(mat, m, n, results, i, j-1));
        //               self     + maxm(top result,                             left result)

        return results[i][j];
    }

    private static int maxm(int a, int b) {
        return a > b ? a : b;
    }



    // 1. parameters - mat, results, m, n, i, j
    // 2. base condition - if 0th row or 0th column, return result
    // 3. return type - int
    // 4. how recursion proceed - Result(i,j) = mat[i][j] + max(Result(i-1,j), Result(i,j-1))


}



// Result(i,j) = mat[i][j] + max(Result(i-1,j), Result(i,j-1))
//                  self   + max(    top result,  left result       )
