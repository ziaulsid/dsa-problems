class Solution {
    public int balancedStringSplit(String s) {
        
        int counter = 0;
        int result = 0;
        for(char c : s.toCharArray()){
            if(c == 'R') ++counter;
            else --counter;
            
            if(counter == 0) result++;
        }
        return result;
        
    }
}