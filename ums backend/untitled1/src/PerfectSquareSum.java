import java.util.Arrays;

public class PerfectSquareSum {

    public static int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp,1<<30);
        dp[0] = 0;

        for (int i = 1; i <= m; ++i) {
            for (int j = i*i; j <= n; ++j) {
                dp[j] = Math.min(dp[j], dp[j- i * i] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        int result = numSquares(n);
        System.out.println("The fewest number of perfect square numbers that add up to " + n + " is: " + result);
    }
}
