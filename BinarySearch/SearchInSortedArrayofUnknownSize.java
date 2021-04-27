/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInSortedArrayofUnknownSize {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        
        while(target > reader.get(right)){
            left = right;
            right *= 2;
        }
        
        while(left <= right){
            
            int mid = left + (right-left)/2;
            if(target == reader.get(mid)) return mid;
            else if (target < reader.get(mid)) right = mid-1;
            else left = mid + 1;
        }
        return -1;
    }
}
