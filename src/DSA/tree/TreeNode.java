package DSA.tree;

public class TreeNode {
    public Object val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {
    }
    
    public TreeNode(Object val) {
        this.val = val;
    }
    
    public TreeNode(Object val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}
