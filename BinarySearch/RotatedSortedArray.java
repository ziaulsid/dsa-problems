class RotatedSortedArray {
    public int search(int[] nums, int target) {
        
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int start = 0;
        int end = nums.length - 1;
        int size = nums.length;
        
        while(start <= end){
            
             int mid = start + (end - start) / 2;
            
            //Case 1 : Mid element is the target
            if(nums[mid] == target) return mid;
            
            //Case 2 :Left half is sorted
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else start = mid + 1;
            }
            else if(nums[mid] <= nums[end]){
                if(target >= nums[mid] && target <= nums[end])
                    start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}