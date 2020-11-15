package TreesProblem;
/*Given a Binary Tree, convert it into its mirror.
        Example 1:

        Input:
        1
        /  \
        2    3
        Output: 2 1 3
        Explanation: The tree is
        1    (mirror)  1
        /  \    =>      /  \
        3    2          2    3
        The inorder of mirror is 2 1 3
        Example 2:

        Input:
        10
        /  \
        20   30
        /  \
        40  60
        Output: 30 10 60 20 40
        Explanation: The tree is
        10               10
        /    \  (mirror) /    \
        20    30    =>   30    20
        /  \                   /   \
        40  60                 60   40
        The inroder traversal of mirror is
        30 10 60 20 40.

        Constraints:
        1 <= Number of nodes <= 100
        1 <= Data of a node <= 1000*/
public class MirrorTree {

    /*The idea is to do inorder traversel of the left subtree until leaf node is found i.e both children of the node are null. Follow the same for right subtree.
    Then move one level up i.e parent node and swap the children.*/

    void mirror(Node node)
    {
        // Your code here

        if(node == null) return;

        if(node.left == null && node.right == null) return;

        /*DFS for left subtree*/
        mirror(node.left);

        /*DFS for right subtree*/
        mirror(node.right);

        /*swap nodes*/
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
