import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder current = new StringBuilder();
        letterCombinationsUtil(current, digits, map, result);
        return result;
    }

    public void letterCombinationsUtil(StringBuilder current, String digits, Map<Character,String> map, List<String> result){

        if(digits.length() == 0){
            result.add(current.toString());
            return;
        }
        String digit = map.get(digits.charAt(0));

        for(int i=0; i<digit.length();i++){
            current.append(digit.charAt(i));
            letterCombinationsUtil(current, digits.substring(1), map, result);
            current.deleteCharAt(current.length()-1);
        }
    }
}
