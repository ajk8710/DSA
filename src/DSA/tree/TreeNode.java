package DSA.tree;

public class TreeNode {
    protected Object val;
    protected TreeNode left;
    protected TreeNode right;
    
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
    
    public Object val() {
        return val;
    }
    
    public TreeNode left() {
        return left;
    }
    
    public TreeNode right() {
        return right;
    }
    
}
