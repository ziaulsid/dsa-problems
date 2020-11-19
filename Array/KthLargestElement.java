import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        for(int i : nums){
            list.add(i);
        }
        Collections.sort(list);

        return list.get(list.size() - k);

    }
}
