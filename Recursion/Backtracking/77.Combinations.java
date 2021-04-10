class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(n, k, current, result, 1);
        
        return result;
    }
    
    void backtrack(int n, int k, List<Integer> current, List<List<Integer>> result, int index){
        
        if(current.size() == k){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i=index; i<=n; i++){
            current.add(i);
            backtrack(n, k, current, result, i+1);
            current.remove(current.size() - 1);
        }
    }
}
