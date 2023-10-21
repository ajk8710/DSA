package DSA.tree.problems;

import java.util.HashMap;

import DSA.tree.MyBinaryTree2;
import DSA.tree.TreeNode;

/*
Pre-order:  {1 2 4 8 9 10 11 5 3 6 7} 
In-order:   {8 4 10 9 11 2 5 1 6 3 7}
Post-order: {8 10 11 9 4 5 2 6 7 3 1}
*/
public class CreateTreeFromPreorderPostorder {
    
    public static void main(String[] args) {
        int[] preorder = new int[] {1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7};
        int[] postorder = new int[] {8, 10, 11, 9, 4, 5, 2, 6, 7, 3, 1};
        
        TreeNode root = createTree(preorder, postorder);
        MyBinaryTree2 tree = new MyBinaryTree2(root);
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
    }
    
    // Considering full tree, pre-order[0] is root and pre-order[1] is left child of root.
    // From post-order array, left of pre-order[1] is descendants of pre-order[1], because post-order is left, right, root.
    // Thus, left of pre-order[1] is left subtree of root.
    // Right of pre-order[1] is right subtree of root.
    
    static HashMap<Integer, Integer> map = new HashMap<>();  // in-order map(value, index)
    static int preIdx = 0;  // index of pre-order
    
    public static TreeNode createTree(int[] preorder, int[] postorder) {
        
        // map for O(1) look up on index of post-order value
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        
        TreeNode root = createTreeRecur(preorder, postorder, 0, postorder.length - 1);
        map = new HashMap<>();  // reset static variables
        preIdx = 0;  // reset static variables
        
        return root;
    }
    
    public static TreeNode createTreeRecur(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        
        // First index of pre-order is always a root of tree
        // Starting from 0 to end of pre-order, construct node
        int preVal = preorder[preIdx];
        TreeNode node = new TreeNode(preVal);
        preIdx++;
        
        if (postStart == postEnd) {
            return node;
        }
        
        int nextPreVal = preorder[preIdx];
        int postIdx = map.get(nextPreVal);  // find position of left child in post-order array
        
        node.left = createTreeRecur(preorder, postorder, postStart, postIdx);  // array up to left child
        node.right = createTreeRecur(preorder, postorder, postIdx + 1, postEnd - 1);  // array after left child and before the node just created
        
        return node;
    }
}
