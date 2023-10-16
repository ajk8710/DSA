package DSA.tree;

public class BSTNode {
    protected int val;
    protected BSTNode left;
    protected BSTNode right;
    
    public BSTNode() {
    }
    
    public BSTNode(int val) {
        this.val = val;
    }
    
    public BSTNode(int val, BSTNode left, BSTNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public int val() {
        return val;
    }
    
    public BSTNode left() {
        return left;
    }
    
    public BSTNode right() {
        return right;
    }
    
}
