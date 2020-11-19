package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithoutDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        return subsets;
    }

    public void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets){

        subsets.add(new ArrayList<>(current));

        for(int i = index; i<nums.length; i++){

            if(i != index && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }
}
