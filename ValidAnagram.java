package Strings;

import java.util.HashMap;
import java.util.Map;

/*PROBLEM DESCRIPTION:

        Given two strings s and t , write a function to determine if t is an anagram of s.

        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true
        Example 2:

        Input: s = "rat", t = "car"
        Output: false
        Note:
        You may assume the string contains only lowercase alphabets.*/
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character,Integer> map = new HashMap<>();

        for(Character c : s.toCharArray()){

            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Character c : t.toCharArray()){

            if(map.get(c) != null) {

                map.put(c, map.get(c) - 1);
            }
        }
        for(Integer value : map.values()){

            if(value > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        boolean isAnagram = validAnagram.isAnagram("anagram", "nagaram");
    }
}
