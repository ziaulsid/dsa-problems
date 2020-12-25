import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        minCoins(n);
    }

    private static void minCoins(int number) {

        int[] dp= new int[number+1];
        Arrays.fill(dp, 1000001);
        dp[0] = 0;

        for (int i = 1; i <= number ; i++) {
            int copy = i;
            while(copy > 0){
                if(i-copy%10 >= 0 && copy%10 !=0){
                    dp[i] = Math.min(dp[i], 1+dp[i- copy%10]);
                }
                copy = copy/10;
            }
        }
        System.out.println(dp[number] == 1000001 ? -1 : dp[number]);
    }
}
