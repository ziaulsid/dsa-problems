import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        List<Integer> input = new ArrayList<>();
        for(int num : nums){
            input.add(num);
        }

        permuteUtil(input, current, result, 0);

        return result;
    }

    public void permuteUtil(List<Integer> input, List<Integer> current, List<List<Integer>> result, int index){

        if(index == input.size()){
            result.add(new ArrayList<>(current));
        }

        for(int i=index; i<input.size();i++){

            current.add(input.get(i));
            Collections.swap(input,i,index);

            permuteUtil(input, current, result, index+1);
            current.remove(current.size()-1);
            Collections.swap(input,i,index);
        }
    }
}
