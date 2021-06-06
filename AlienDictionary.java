class AlienDictionary{
public String alienOrder(String[] words) {
    
    // Step 0: Create data structures and find all unique letters.
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> counts = new HashMap<>();
    
    for(String word : words){
        for(Character c : word.toCharArray()){
            graph.put(c, new ArrayList<Character>());
            counts.put(c,0);
        }
    }
    
    // Step 1: Find all edges.
    for(int i=0; i<words.length-1; i++){
        String word1 = words[i];
        String word2 = words[i+1];
        if(word1.length() > word2.length() && word1.startsWith(word2)){
            return "";
        }
        for(int j=0; j<Math.min(word1.length(), word2.length()); j++){
            if(word1.charAt(j) != word2.charAt(j)){
                graph.get(word1.charAt(j)).add(word2.charAt(j));
                counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                break;
            }
        }
    }
    
    
    // Step 2: Breadth-first search.
    Queue<Character> q = new LinkedList<>();
    for(Character c : counts.keySet()){
        if(counts.get(c) == 0){
            q.add(c);
        }
    }
    StringBuilder result = new StringBuilder();
    while(!q.isEmpty()){
        Character c = q.poll();
        result.append(c);
        
        for(Character edge : graph.get(c)){
            counts.put(edge, counts.get(edge) - 1);
            
            if(counts.get(edge) == 0){
                q.add(edge);
            }
        }
    }
    if(result.length() < counts.size()){
        return "";
    }
    return result.toString();
    
}
}
