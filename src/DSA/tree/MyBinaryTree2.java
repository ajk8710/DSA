package DSA.tree;

// Binary Tree with Node Implementation
public class MyBinaryTree2 {
    
    private TreeNode root;
        
    public MyBinaryTree2() {
    }
    
    public MyBinaryTree2(Object[] arr) {
        root = createTree(arr, 0);
    }
    
    public MyBinaryTree2(TreeNode root) {
        this.root = root;
    }
    
    public TreeNode createTree(Object[] arr, int i) {
        TreeNode Node = null;
        if (i < arr.length) {  // terminate condition
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
        if (node != null && node.val != null) {
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
        if (node != null && node.val != null) {
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
        if (node != null && node.val != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.val + " ");
        }
    }
    
}
