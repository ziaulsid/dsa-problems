class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        int size = nums.length;
        
        while(start <= end){
            
            //Case 1 : Array is not rotated
            if(nums[start] <= nums[end]) return nums[start];
            
            int mid = start + (end - start) / 2;
            int prev = (mid + size - 1) % size;
            int next = (mid + 1) % size;
            
            //Case 2 : The element at mid index is the smallest element
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) return nums[mid];
            else{
                
                //Case 3: Left half is sorted
                if(nums[start] <= nums[mid])
                    start = mid + 1;
                //Case 4 : Right half is sorted    
                else end = mid - 1;
                
            }
        }
        return -1;
    }
}