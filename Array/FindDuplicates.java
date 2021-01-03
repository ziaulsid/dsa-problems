import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums);
    }
    /*Intuition: For every element negate the value at index [element-1]*/
    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if(nums[Math.abs(num) - 1] < 0){
                result.add(Math.abs(num));
            }else{
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return result;
    }
}
