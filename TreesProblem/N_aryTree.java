package TreesProblem;

import java.util.ArrayList;
import java.util.List;

class N_aryTreeNode {
    public int val;
    public List<N_aryTreeNode> children;


    public N_aryTreeNode() {
        children = new ArrayList<N_aryTreeNode>();
    }

    public N_aryTreeNode(int _val) {
        val = _val;
        children = new ArrayList<N_aryTreeNode>();
    }

    public N_aryTreeNode(int _val, ArrayList<N_aryTreeNode> _children) {
        val = _val;
        children = _children;
    }
};

/*You are given all the nodes of an N-ary tree as an array of Node objects, where each node has a unique value. Return the root of the N-ary tree.

        Custom testing:

        An N-ary tree can be serialized as represented in its level order traversal where each group of children is separated by the null value (see examples).

        Input: tree = [1,null,3,2,4,null,5,6]
        Output: [1,null,3,2,4,null,5,6]
        Explanation: The tree from the input data is shown above.
        The driver code creates the tree and gives findRoot the Node objects in an arbitrary order.
        For example, the passed array could be [Node(5),Node(4),Node(3),Node(6),Node(2),Node(1)] or [Node(2),Node(6),Node(1),Node(3),Node(5),Node(4)].
        The findRoot function should return the root Node(1), and the driver code will serialize it and compare with the input data.
        The input data and serialized Node(1) are the same, so the test passes.*/
/*


Intuition: If we traverse the list and find the children of all the element we will visit all the nodes twice (both parent and child) except Root node
So we create a sum variable and add the parent and subtract the children which basically cancells out all the nodes who have a children and we are left with the root node.*/
public class N_aryTree {
    public N_aryTreeNode findRoot(List<N_aryTreeNode> tree) {

        int sum = 0;
        for(N_aryTreeNode node : tree){
            System.out.print(node.val + " ");
        }
        for(N_aryTreeNode node : tree){
            sum += node.val;
            for(N_aryTreeNode child: node.children){
                sum -= child.val;
            }
        }
        for(N_aryTreeNode node : tree){
            if(node.val == sum) return node;
        }
        return null;
    }
}
