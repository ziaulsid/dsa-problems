package TreesProblem;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        populateMap(inorder,map);
        return buildTreeUtil(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end){

        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if(start == end) return root;

        int inIndex = map.get(root.val);

        root.left = buildTreeUtil(preorder, inorder, start, inIndex-1);
        root.right = buildTreeUtil(preorder, inorder, inIndex+1, end);

        return root;
    }

    private void populateMap(int[] inorder, Map<Integer, Integer> map){
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
    }
}
