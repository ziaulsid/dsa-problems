package LeetCodeMarchChallenge;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        int result = 0;
        int index = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int j=0; j<keyboard.length(); j++){
            map.put(keyboard.charAt(j), j);
        }

        for(int i=0;i<word.length();i++){
            int currIndex = map.get(word.charAt(i));
            result += Math.abs(currIndex - index);
            index = currIndex;
        }
        return result;
    }
}
