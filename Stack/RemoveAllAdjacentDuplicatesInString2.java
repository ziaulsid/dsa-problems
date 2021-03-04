import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString2 {

    /*Array Based Solution*/
    public String removeDuplicatesUsingArrays(String s, int k) {

        int[] count = new int[s.length()];
        StringBuilder builder = new StringBuilder(s);

        for(int i=0; i<builder.length(); i++){
            if(i == 0 || builder.charAt(i) != builder.charAt(i-1)){
                count[i] = 1;
            }else{
                count[i] = count[i-1] + 1;
                if(count[i] == k){
                    builder.delete(i-k+1, i+1);
                    i = i-k;
                }
            }
        }
        return builder.toString();
    }

    /*Stack Based Solution*/
    public String removeDuplicates(String s, int k) {

        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty() || s.charAt(i) != stack.peek().character){
                stack.push(new Pair(1, s.charAt(i)));
            }else{
                if(++stack.peek().count == k){
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            for(int i=1; i<=pair.count;i++){
                sb.append(pair.character);
            }
        }
        return sb.reverse().toString();
    }
}

class Pair {
    int count;
    char character;
    public Pair(int count, char character) {
        this.character = character;
        this.count = count;
    }
}
