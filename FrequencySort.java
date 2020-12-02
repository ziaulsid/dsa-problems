public class FrequencySort {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        //Put all the frequency in a map
        for(int i=0; i<s.length(); i++){

            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }else{

                map.put(s.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        StringBuilder builder  = new StringBuilder();

        for (Map.Entry<Character, Integer> aa : list) {

            int value = aa.getValue();
            while(value > 0){

                builder.append(aa.getKey());
                value--;
            }
        }

        return new String(builder);
    }
}
