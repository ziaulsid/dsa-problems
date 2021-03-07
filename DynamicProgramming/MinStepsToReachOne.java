public class MinStepsToReachOne {

    public int minSteps(int number){

        if(number <= 1) return 0;
        int[] dp = new int[number+1];

        return minStepsUtil(number,dp);
    }

    private int  minStepsUtil(int number, int[] dp) {

        if(number == 1) return 0;
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;
        int opt3 = Integer.MAX_VALUE;
        if(dp[number] != 0) {
            return dp[number];
        }
        if(number % 3 == 0){
            opt1 = minStepsUtil(number/3,dp);
        }
        if(number % 2 == 0){
            opt2 = minStepsUtil(number/2,dp);
        }
        opt3 = minStepsUtil(number-1,dp);

        dp[number] = Math.min(Math.min(opt1,opt2),opt3) + 1;
        return dp[number];
    }

    public static void main(String[] args) {
        MinStepsToReachOne minStepsToReachOne = new MinStepsToReachOne();
        int minSteps = minStepsToReachOne.minSteps(10);
        System.out.println(minSteps);
    }
}
