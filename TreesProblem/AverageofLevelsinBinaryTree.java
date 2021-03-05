package TreesProblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() != 0){

            int size = queue.size();
            double levelVal = 0;
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                levelVal += node.val;

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(levelVal/size);
        }
        return result;
    }
}
