package Strings;
/*PROBLEM DESCRIPTION:
        Implement strStr().

        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
        Example 1:

        Input: haystack = "hello", needle = "ll"
        Output: 2
        Example 2:

        Input: haystack = "aaaaa", needle = "bba"
        Output: -1
        Example 3:

        Input: haystack = "", needle = ""
        Output: 0*/
public class SubStr {

    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) return 0;

        if (haystack.length() < needle.length()) return -1;

        int firstOccurrence = -1;
        for(int i=0; i<=haystack.length() - needle.length(); i++){

            int j = 0;
            for(j=0; j<needle.length(); j++){

                if(needle.charAt(j) != haystack.charAt(i + j)){
                    break;
                }
            }
            if (j == needle.length()){

                firstOccurrence = i;
                return firstOccurrence;

            }
        }
        return firstOccurrence;
    }

    public static void main(String[] args) {

        strStr("mississippi","mississippi");
    }
}
