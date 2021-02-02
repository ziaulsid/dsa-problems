Given the roots of two binary trees p and q, write a function to check if they are the same or not.

/*Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //Check for leaf node
        if(p == null && q == null) return true;
      
       // Check if one node is different from another
        if(p == null || q == null) return false;
        
        //Intuition : Check current node val and ask the left subtree and right subtree for the val.
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}