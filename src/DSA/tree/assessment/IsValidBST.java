package DSA.tree.assessment;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
Input: root = [2, 1, 3]
Output: true

Input: root = [5, 1, 4, null, null, 3, 6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/
public class IsValidBST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new Integer[] {2, 1, 3});
        tree.printInorder();
        tree.printPostorder();
        tree.printPreorder();
        
        System.out.println("{2, 1, 3}: " + isValidBST(tree.root()));
        tree = new BinaryTree(new Integer[] {5, 1, 4, null, null, 3, 6});
        System.out.println("{5, 1, 4, null, null, 3, 6}: " + isValidBST(tree.root()));
    }

    public static boolean isValidBST(TreeNode root) {
        return isInBound(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    // If goes left: boundary = leftBound (same) ~ node.val
    // If goes right: boundary = node.val ~ rightBound (same)
    public static boolean isInBound(TreeNode node, double leftBound, double rightBound) {
        if (node == null) return true;
        if ( !(leftBound < node.val && node.val < rightBound) ) {  // if not inBound
            return false;
        }
        return isInBound(node.left, leftBound, node.val) && isInBound(node.right, node.val, rightBound);
    }
    
//    static TreeNode preNode = null;
//    
//    public static boolean isValidBSTUsingInorder (TreeNode node) {
//        if (node == null) return true;
//
//        boolean lefty = isValidBSTUsingInorder(node.left);
//        
//        preNode = new TreeNode(node.val);
//        
//        // visit node
//        int whatWasPreval = preVal;
//        preVal = node.val;
//        return  && node.val <= whatWasPreval;
//        return node.val;
//        
//    }
    
    // This doesn't compare with grandparents
    public static boolean isValidBSTNotCorrect(TreeNode node) {
        if (node == null) return true;
        
        if (node.left != null) {
            if (node.left.val > node.val) return false;
        }
        
        if (node.right != null) {
            if (node.val > node.right.val) return false;
        }
        
        return isValidBSTNotCorrect(node.left) && isValidBSTNotCorrect(node.right);
    }
    
}
