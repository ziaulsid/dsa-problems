package LinkedList;

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flattenUtil(root);             
    }
    
    public TreeNode flattenUtil(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        
        TreeNode left = flattenUtil(root.left);
        TreeNode right = flattenUtil(root.right);
        
        if(left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }        
        return right == null ? left : right;
    }
}