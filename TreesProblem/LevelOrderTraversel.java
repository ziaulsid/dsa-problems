package TreesProblem;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversel {

    public  static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> curr = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i<size; i++){

                TreeNode currElement = queue.remove();
                curr.add(currElement.val);

                if(currElement.left != null){

                    queue.add(root.left);
                }
                if(currElement.right != null){

                    queue.add(root.right);
                }
            }
            result.add(curr);
            System.out.println();
        }
        return result;
    }
}


 // Definition for a binary tree node.
 class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

     public static void main(String[] args) {
         TreeNode left = new TreeNode(2);
         TreeNode right = new TreeNode(3);
         TreeNode root = new TreeNode(1,left,right);

         List<List<Integer>> levelOrder = LevelOrderTraversel.levelOrder(root);

         levelOrder.forEach(list -> {
             list.forEach(System.out::println);
         });

     }
 }
