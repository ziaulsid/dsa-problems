class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        
        for(int end = 0;end<s.length();end++){
            Character c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);
            
            if(map.size() > k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if(map.get(s.charAt(start)) == 0){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
