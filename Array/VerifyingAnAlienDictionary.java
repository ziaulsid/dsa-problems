class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int p =0;
            int q=0;
            int charDiff = 0;
            
            while(p < w1.length() && q < w2.length() && charDiff == 0){
                
                charDiff = map.get(w1.charAt(p)) - map.get(w2.charAt(q));
                p++;
                q++;
            }
            if(charDiff == 0 && w1.length() > w2.length()) return false;

            if(charDiff > 0) return false;
        }
        return true;
    }
}
