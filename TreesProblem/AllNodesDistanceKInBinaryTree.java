/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AllNodesDistanceKInBinaryTree {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        
        dfs(root, null, parentMap);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        int level = 0;
        
        q.add(target);
        set.add(target);
        
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            
            if(level == k){
                while(!q.isEmpty()){
                    result.add(q.poll().val);
                }
            }
            else{
                int size = q.size();
            
                for(int i=0; i<size; i++){
                    TreeNode current = q.poll();
                    if(current.left != null && !set.contains(current.left)){
                        q.add(current.left);
                        set.add(current.left);
                    }
                    if(current.right != null && !set.contains(current.right)){
                        q.add(current.right);
                        set.add(current.right);
                    }
            
                    if(parentMap.get(current) != null && !set.contains(parentMap.get(current))){
                        q.add(parentMap.get(current));
                        set.add(parentMap.get(current));
                    }
                }
            }
            ++level;
        }               
        return result;
    }
    
    public void dfs(TreeNode node, TreeNode parent, Map<TreeNode,TreeNode> parentMap){
        
        if(node != null){
            parentMap.put(node, parent);
            dfs(node.left, node, parentMap);
            dfs(node.right, node, parentMap);
        }
    }
}
