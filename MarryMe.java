import java.util.Scanner;

public class MarryMe {
    private static boolean isSubsequence(String first, String second) {
        // check if first is subsequence in second or not.
        int m = first.length();
        int n = second.length();

        int i = 0, j = 0;
        while(i < m && j < n) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == m) {
            // first string is fully processed
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-- != 0) {
            // for all test cases
            String first, second;
            first = sc.nextLine();
            second = sc.nextLine();
            if (isSubsequence(first,second) || isSubsequence(second, first)) {
                // yes he will have to marry
                System.out.println("#SadLife");
            } else {
                System.out.println("#DieSingle");
            }
        }
    }
}
