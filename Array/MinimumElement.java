import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumElement {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++) {
            minDiff = Math.min(arr[i+1] - arr[i], minDiff);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++) {
            if(minDiff == (arr[i+1] - arr[i])) {
                res.add(new ArrayList<Integer>(List.of(arr[i], arr[i+1])));
            }
        }
        return res;

    }
}
