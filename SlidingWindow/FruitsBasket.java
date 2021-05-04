class FruitsBasket {
    public int totalFruit(int[] tree) {
        /*Longest Substring with 2 characters*/
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int K=2;
        int count = 0;
        for(int end=0;end<tree.length;end++){
            
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
            
            while(map.size() > K){
                map.put(tree[start], map.get(tree[start]) - 1);
                
                if(map.get(tree[start]) == 0) map.remove(tree[start]);
                start++;
            }
            
            count = Math.max(count, end - start + 1);
        }
        return count;
    }
}
