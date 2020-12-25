/* Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.*/
class Solution {
    public int numSquares(int n) {
        // Intuition: Same as coin change problem, instead of coins we have perfect square
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        
        int max_square_index = (int) Math.sqrt(n) + 1;
        //System.out.println(max_square_index);
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1; j<max_square_index; j++){
                if(i-square_nums[j] >= 0){
                    dp[i] = Math.min(dp[i], 1+dp[i-square_nums[j]]);
                }
                
            }
        }        
        return dp[n];
    }
}