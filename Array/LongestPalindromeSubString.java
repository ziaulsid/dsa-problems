public class LongestPalindromeSubString {

    /*Time Complexity : O(n^3)*/
    /*This solution won't work in LeetCode or any other coding platforms*/
    public static String longestPalindrome(String s) {

        int max = Integer.MIN_VALUE;
        String maxPalindrome = "";
        for(int i=0; i<s.length(); i++){

            for(int j=i; j<s.length(); j++){

                StringBuilder sb = new StringBuilder();
                for(int k=i; k<=j; k++){

                    sb.append(s.charAt(k));

                    if (k == j){
                        if(isPalindrome(sb)){
                            if (max < sb.length()){
                                max = sb.length();
                                maxPalindrome = sb.toString();
                            }
                        }
                    }
                }

            }
        }
        return maxPalindrome;
    }

    public static boolean isPalindrome(StringBuilder sb) {

        if(sb.length() == 1) return  true;
        int left = 0;
        int right = sb.length() - 1;

        while (left <= right){

            if(sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /*Time Complexity : O(n^2)*/
    /*This solution is the most optimized solution with constant space*/
    public String longestPalindromeOptimized(String s) {

        StringBuilder maxPalindrome = new StringBuilder();
        //String maxPalindrome = "";

        for(int i=0; i<s.length(); i++){

            StringBuilder s1 = isPalindrome(s,i,i);
            StringBuilder s2 = isPalindrome(s,i,i+1);
            if(s1.length() > s2.length() && s1.length() > maxPalindrome.length()) maxPalindrome = s1;
            else if(s2.length() > s1.length() && s2.length() > maxPalindrome.length()) maxPalindrome = s2;
        }
        return maxPalindrome.toString();
    }

    public static StringBuilder isPalindrome(String s, int low, int high) {

        StringBuilder sb = new StringBuilder();

        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){

            low--;
            high++;
        }
        sb.append(s.substring(low+1, high));

        return sb;
    }

    public static void main(String[] args) {
        System.out.println("longestPalindrome: "+  longestPalindrome("babad"));
    }
}
