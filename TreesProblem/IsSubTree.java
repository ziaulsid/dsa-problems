package TreesProblem;

public class IsSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        return s!=null && (equals(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t));
    }


    public boolean equals(TreeNode s, TreeNode t){

        if(s==null && t==null) return true;
        if(s==null || t==null) return false;

        return s.val==t.val && equals(s.left,t.left) && equals(s.right,t.right);
    }
}
