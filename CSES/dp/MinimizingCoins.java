import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {

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

        minCoins(coins, money);
    }

    private static void minCoins(int[] coins, int amount) {

        int[] dp= new int[amount+1];
        Arrays.fill(dp, 1000011);
        dp[0] = 0;

        for (int i = 1; i <= amount ; i++) {

            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }
        System.out.println(dp[amount] == 1000011 ? -1 : dp[amount]);
    }
}
