class DecodeWays {
    public int numDecodings(String s) {
        
       Map<Integer,Integer> map = new HashMap<>(); 
        return backtrack(s,0,map);
    }
    
    public int backtrack(String s, int index, Map<Integer,Integer> map){
        
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if(index == s.length())
            return 1;
        
        int ans = 0;
        
        for(int i=index; i<s.length();i++){
            
            int j = index;
            int curr = 0;
            while(j<=i){
                curr = (curr*10) + (s.charAt(j) - '0'); 
                j++;
                if(curr > 26)
                    return ans;
            }
            
            if(curr == 0)
                return 0;
            
           
            ans += backtrack(s,i+1,map);
            map.put(index,ans);
            
        }
        return ans;
    }
}
