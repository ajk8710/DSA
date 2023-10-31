package DSA.tree.assessment;

// Binary Tree with Node Implementation
public class BinaryTree {
    
    private TreeNode root;
        
    public BinaryTree() {
    }
    
    public BinaryTree(Integer[] arr) {
        root = createTree(arr, 0);
    }
    
    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    
    public TreeNode createTree(Integer[] arr, int i) {
        TreeNode Node = null;
        if (i < arr.length && arr[i] != null) {  // terminate condition
            Node = new TreeNode(arr[i]);
            Node.left = createTree(arr, 2 * i + 1);
            Node.right = createTree(arr, 2 * i + 2);
        }
        return Node;
    }
    
    public TreeNode root() {
        return root;
    }
    
    public void printInorder() {
        inorder(root);
        System.out.println();
    }
    
    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }
    
    public void printPreorder() {
        preorder(root);
        System.out.println();
    }
    
    public void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    public void printPostorder() {
        postorder(root);
        System.out.println();
    }
    
    public void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.val + " ");
        }
    }
    
}
