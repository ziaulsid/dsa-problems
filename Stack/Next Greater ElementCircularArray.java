/*Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. 
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number.
If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.*/

public class NextGreaterElementCircularArray {

    public int[] nextGreaterElements(int[] nums) {
        
        int index = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = index; i<nums.length; i++){
            
            
            //for loop (i+1...n-1)
            int k=0;
            for(k=i+1; k<nums.length; k++){
                if(nums[k] > nums[i]){
                    result[i] = nums[k];
                    break;
                }
            }
            
            //for loop (0..i-1)
            if(result[i] == -1 && k >= nums.length){
                for(int j=0; j<=i-1; j++){
                    if(nums[j] > nums[i]){
                        result[i] = nums[j];
                        break;
                    }
                }
            }
        }
        return result;
    }
}
