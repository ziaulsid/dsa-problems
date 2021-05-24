class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        
        if(s.length() == 0 && t.length() == 0) return false;
        if(s.equals(t)) return false;
        if(s.length() == t.length()){
            return replaceString(s,t);
        }else if(s.length() + 1 == t.length()){
            return insertString(s,t);
            
        }else if(s.length() - 1 == t.length()){
            return insertString(t,s);
        }
        return false;
    }
    
    public boolean replaceString(String s, String t){
        int m = 0;
        int n = 0;
        int count = 0;
        while(m < s.length() && n < t.length()){
            if(s.charAt(m++) != t.charAt(n++)) count++;
            
            if(count > 1) return false;
        }
        return true;    
    }
    
    public boolean insertString(String s, String t){
        int start = 0;
        int end = 0;
        
        while(start < s.length() && end < t.length()){
            if(s.charAt(start) != t.charAt(end)){
                if(start != end) return false;
            end++;
            }else{
                start++;
                end++;
            }
        }
        
        return true;
    }
    
}
