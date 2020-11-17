package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringAnagram {

    static String sortString(String inputString){


        // Convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // Sort tempArray
        Arrays.sort(tempArray);

        // Return new sorted string
        return new String(tempArray);
    }

     /*Function to return the count of anagrams*/
    static void count(List<String> dictionary, List<String> queries){


        /*Store the frequencies of Strings in arr1[]*/
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : dictionary)
        {

            // Sort the String
            word = sortString(word);

             /*Increase its frequency in the map*/
            if (map.containsKey(word))
            {
                map.put(word, map.get(word) + 1);
            }
            else
            {
                map.put(word, 1);
            }
        }

        for(String query : queries)
        {
            // Sort the String
            query = sortString(query);

            /*Display its anagrams in arr1[]*/
            System.out.print(map.get(query) + " ");
        }
    }

    public static void main(String[] args){

        List<String> dictionary = Arrays.asList( "geeks", "learn", "for", "egeks", "ealrn" );

        List<String> query = Arrays.asList( "kgees", "rof", "nrael" );

        count(dictionary, query);
    }
}
