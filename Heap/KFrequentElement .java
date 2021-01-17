class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new
            PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? 
                    Integer.compare(b.getKey(), a.getKey()) : 
                    Integer.compare(b.getValue(), a.getValue()));
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            heap.offer(entry);
        
        for(int i=0; i<k; i++){
            result[i] = heap.poll().getKey();
        }
        
        return result;
    }
}