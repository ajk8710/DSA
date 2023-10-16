package DSA.tree;

public class BinarySearchTree {
    BSTNode root;
    
    public void insertIterative(int val) {
        if (root == null) {
            root = new BSTNode(val);
        }
        else {
            insertIter(root, val);
        }
    }
    
    private void insertIter(BSTNode node, int val) {
        if (val < node.val) {  // if less than the node
            if (node.left == null) {  // if left is null, create new node as the left
                node.left = new BSTNode(val);
                return;
            }
            else {
                insertIter(node.left, val);  // if left is not null, compare with left. Recursive portion of iterative method
            }
        }
        else {  // if equal or greater than the node
            if (node.right == null) {  // if right is null, create new node as the left
                node.right = new BSTNode(val);
                return;
            }
            else {
                insertIter(node.right, val);  // if right is not null, compare with left. Recursive portion of iterative method
            }
        }
    }
    
    public void insertRecursive(int val) {
        root = insertRecur(root, val);
    }
    
    private BSTNode insertRecur(BSTNode node, int val) {
        if (node == null) {  // terminate condition
            node = new BSTNode(val);
            return node;
        }
        
        if (val < node.val) {
            node.left = insertRecur(node.left, val);
            return node;
        }
        else {
            node.right = insertRecur(node.right, val);
            return node;
        }
    }
    
    public void printInorder() {
        inorder(root);
        System.out.println();
    }
    
    private void inorder(BSTNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    
    public void printPreorder() {
        preorder(root);
        System.out.println();
    }
    
    private void preorder(BSTNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
    
    public void printPostorder() {
        postorder(root);
        System.out.println();
    }
    
    private void postorder(BSTNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }
}
