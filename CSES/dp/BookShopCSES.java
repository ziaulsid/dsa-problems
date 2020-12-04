import java.util.Scanner;

public class BookShopCSES {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[2];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }
        int numberOfBooks = numbers[0];
        int maxPrice = numbers[1];
        scanner.nextLine();

        int[] bookPrices = new int[numberOfBooks];
        for (int i = 0; i < bookPrices.length; i++){
            bookPrices[i] = scanner.nextInt();
        }

        scanner.nextLine();
        int[] bookPages = new int[numberOfBooks];
        for (int i = 0; i < bookPages.length; i++){
            bookPages[i] = scanner.nextInt();
        }

        int maxBookPages = maximizeBooks(numberOfBooks ,maxPrice, bookPrices, bookPages);
        System.out.println(maxBookPages);
    }

    private static int maximizeBooks(int numberOfBooks, int maxPrice, int[] bookPrices, int[] bookPages) {

        int[][] dp = new int[numberOfBooks+1][maxPrice+1];
        //Populate rows
        for (int i = 0; i < maxPrice+1; i++) {
            dp[0][i] = 0;
        }

        //Populate columns
        for (int i = 0; i < numberOfBooks+1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < numberOfBooks+1; i++) {
            for (int j = 1; j < maxPrice+1; j++) {
                //Check Current capacity less than book price
                if(bookPrices[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int remPrice = j - bookPrices[i-1];
                    dp[i][j] = Math.max(dp[i-1][j], bookPages[i-1] + dp[i-1][remPrice]);
                }
            }
        }
        return dp[numberOfBooks][maxPrice];
    }
}
