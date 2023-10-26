package DSA.tree;

public class AVLNode {
    public int val;
    public AVLNode left;
    public AVLNode right;
    public int height = 1;
    
    public AVLNode() {
    }
    
    public AVLNode(int val) {
        this.val = val;
    }
    
    public AVLNode(int val, AVLNode left, AVLNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}
