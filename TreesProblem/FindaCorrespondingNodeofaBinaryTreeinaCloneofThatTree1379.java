package TreesProblem;

/*Intuition: Perform PreOrder Traversel and check if the current node is the target node. If not ask left and right subtrees for the ans*/
public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        TreeNode result = null;
        if(cloned == null) return null;

        if(cloned.val == target.val) return cloned;

        result = getTargetCopy(original, cloned.left, target);

        /*If result is found no need to make a call to the right subtree*/
        if(result != null) return result;
        else{
            result = getTargetCopy(original, cloned.right, target);
        }
        return result;
    }
}
