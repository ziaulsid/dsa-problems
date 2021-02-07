/*
        Given an unsorted integer array nums, find the smallest missing positive integer.



        Example 1:

        Input: nums = [1,2,0]
        Output: 3
        Example 2:

        Input: nums = [3,4,-1,1]
        Output: 2
        Example 3:

        Input: nums = [7,8,9,11,12]
        Output: 1


        Constraints:

        0 <= nums.length <= 300
        -231 <= nums[i] <= 231 - 1

        Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?*/

public class FindFirstMissingPositiveNumber {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int missingNumber = 0;
        boolean foundOne = false;
        for(int i : nums){
            if(i == 1) foundOne = true;
        }

        if(!foundOne) return 1;

        for(int i=0; i < n; i++){
            if(nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }

        for(int i=0; i < n; i++){

            //If the value is already marked as negatie then it will throw IndexOutOFBoundException. Hence taking the absolute value
            int a = Math.abs(nums[i]);

            if(a == n){
                nums[0] = - Math.abs(nums[0]);
            }else{
                //If duplicate value is found then negating the value seconed time will make the value positive
                nums[a] = - Math.abs(nums[a]);
            }

        }

        for(int i=1; i < n; i++){
            if(nums[i] > 0) {
                return i;
            }
        }

        //This condition is to evaluate whether we had n in the input array. If we had n in the array nums[0] will be -ve and in that case n+1 will be returned.
        if(nums[0] > 0) return n;
        return n+1;
    }
}
