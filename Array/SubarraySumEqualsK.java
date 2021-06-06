class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            int comp = sum - k;
            if(map.containsKey(comp)){
                count += map.get(comp);
            }
            
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
