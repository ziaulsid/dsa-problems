class Solution {
    public int findPeakElement(int[] nums) {
     
        return findPeakElementUtil(nums, 0, nums.length-1);
    }
    
    public int findPeakElementUtil(int[] nums, int start, int end){
        
        int mid = start + (end-start)/2;
        
        if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) return mid;
        
        else if(nums[mid + 1] > nums[mid]){
            return findPeakElementUtil(nums, mid + 1, end);
        }
        else{
            return findPeakElementUtil(nums, 0, mid - 1);
        }
    }
}
