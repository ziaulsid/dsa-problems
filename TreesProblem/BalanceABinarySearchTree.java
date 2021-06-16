class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> inOrderList = new ArrayList<>();
        inorder(root,inOrderList);
        
        return balancedBST(inOrderList, 0, inOrderList.size()-1);
        
    }
    
    private TreeNode balancedBST(List<Integer> list, int low, int high){
        
        if(high < low){
            return null;
        }
        
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = balancedBST(list, low, mid-1);
        root.right = balancedBST(list, mid+1, high);
        
        return root;
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        
        if(root.left != null){
            inorder(root.left,list);
        }
        
        list.add(root.val);
        
        if(root.right != null){
             inorder(root.right,list);
        }
        
    }
}
