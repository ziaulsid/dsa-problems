class Solution {
    public int romanToInt(String s) {
        
        int result = 0;
        
        Map<Character, Integer> symbolValues = new HashMap<>();
        symbolValues.put('I',1);
        symbolValues.put('V',5);
        symbolValues.put('X',10);
        symbolValues.put('L',50);
        symbolValues.put('C',100);
        symbolValues.put('D',500);
        symbolValues.put('M',1000);
        
        for(int i=0; i<s.length();i++){
            
            char c = s.charAt(i);
            char nextChar=0;
            if(i+1 < s.length()){
                 nextChar = s.charAt(i+1);    
            }
            
            if(c == 'I' && (nextChar == 'V' || nextChar == 'X')){
                result -= symbolValues.get(c);    
            }else if(c == 'X' && (nextChar == 'L' || nextChar == 'C')){
                result -= symbolValues.get(c);
            }else if(c == 'C' && (nextChar == 'D' || nextChar == 'M')){
                result -= symbolValues.get(c);
            }else{
                result += symbolValues.get(c);
            }
            
        }
        
        return result;
    }
}
