package TreesProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumUtil(root, sum, path, result);

        return result;
    }
/*
    Intuition: 1. Check if node value is equal to sum and node is a leaf node then add the path to the result list by creating a new ArrayList
               2. If node is != sum then add the current node value in the path list and recur on both left and right children
               3. If path is found in the recursive stack then add the path list in the result list and backtrack(remove the last element in the list).*/
    public void pathSumUtil(TreeNode root, int sum, List<Integer> path,List<List<Integer>> result) {

        if(root == null) {
            return;
        }

        path.add(root.val);

        if(root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        else{
            pathSumUtil(root.left, sum-root.val,path,result);
            pathSumUtil(root.right, sum-root.val,path,result);
        }

        /*Backtracking Step*/
        path.remove(path.size()-1);

    }
}
