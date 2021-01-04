package Strings;

public class PalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaaaa";

        System.out.println(countSubstrings(s));
    }

    private static int countSubstrings(String s) {

        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];

        /*One letter substrings are palindrome by default*/
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
        }

        for (int k = 2; k < n; k++) {
            for (int i = 0, j = i+k; j < n; j++,i++) {
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
