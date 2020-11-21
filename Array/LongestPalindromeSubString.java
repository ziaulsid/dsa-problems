public class LongestPalindromeSubString {

    /*Time Complexity : O(n^2)*/
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

    public static void main(String[] args) {
        System.out.println("longestPalindrome: "+  longestPalindrome("babad"));
    }
}
