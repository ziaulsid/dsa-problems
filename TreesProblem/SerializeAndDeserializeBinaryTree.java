/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "X";
        
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + 
            serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String s : arr){
            q.add(s);
        }
        return deserializeUtil(q);
    }
    
    public TreeNode deserializeUtil(Queue<String> q){
        
        if(q.peek().equals("X")) {
            q.poll();
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(q.poll()));
        node.left = deserializeUtil(q);
        node.right = deserializeUtil(q);
        
        return node;
        
    }
}
