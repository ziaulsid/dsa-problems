import java.util.Scanner;

public class DiceCombination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        final int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= 6; j++) {

                if(i-j < 0) continue;
                dp[i] =(dp[i]%mod + dp[i-j]%mod)%mod;
            }
        }
        System.out.println(dp[n]);
        //System.out.println(diceCombinationTopDown(n,0, dp));
    }

    private static int diceCombinationTopDown(int n, int ways, int[] dp) {

        final int mod = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        if(n == 0) return dp[0];
        for (int i = 1; i <= 6 ; i++) {
            if(dp[n] != 0) return dp[n];
            if(n-i >= 0) {
                 ways  += diceCombinationTopDown(n-i, 0, dp);
            }
        }
        dp[n] = mod(ways, mod);
        return dp[n];
    }

    private static int mod(int a, int m)
    {
        return (a%m + m) % m;
    }
}
