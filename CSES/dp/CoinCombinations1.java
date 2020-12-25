import java.util.Scanner;

public class CoinCombinations1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] firstInput = new int[2];
        for (int i = 0; i < firstInput.length; i++){
            firstInput[i] = scanner.nextInt();
        }

        int numberOfCoins = firstInput[0];
        int money = firstInput[1];

        int[] coins = new int[numberOfCoins];
        for (int i = 0; i < coins.length; i++){
            coins[i] = scanner.nextInt();
        }

        numWays(coins, money);
    }

    private static void numWays(int[] coins, int money) {

        int[] dp = new int[money+1];
        dp[0] = 1;

        final int mod = 1000000007;

        for (int i = 1; i <= money; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0){
                    dp[i] = (dp[i] + dp[i-coins[j]] ) % mod;
                }
            }
        }
        System.out.println(dp[money] % mod);
    }
}