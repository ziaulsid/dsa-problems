public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int curr_max = 0;
        for(int i : nums){
            curr_max += i;
            max = Math.max(max, curr_max);

            if(curr_max < 0) curr_max = 0;
        }
        return max;
    }
}
