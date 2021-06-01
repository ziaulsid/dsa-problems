public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = maxProduct;

        for(int i=1; i<nums.length;i++){
            int tempMaxProduct = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));

            maxProduct = tempMaxProduct;
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
