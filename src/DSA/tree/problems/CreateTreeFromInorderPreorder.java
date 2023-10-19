package DSA.tree.problems;

import java.util.HashMap;

import DSA.tree.MyBinaryTree2;
import DSA.tree.TreeNode;

/*
Pre-order:  {1 2 4 8 9 10 11 5 3 6 7} 
In-order:   {8 4 10 9 11 2 5 1 6 3 7}
Post-order: {8 10 11 9 4 5 2 6 7 3 1}
*/
public class CreateTreeFromInorderPreorder {
    
    public static void main(String[] args) {
        int[] preorder = new int[] {1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7};
        int[] inorder = new int[] {8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7};
        
        TreeNode root = createTree(preorder, inorder);
        MyBinaryTree2 tree = new MyBinaryTree2(root);
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
    }
    
    static HashMap<Integer, Integer> map = new HashMap<>();  // in-order map(value, index)
    static int preIdx = 0;  // index of pre-order
    
    public static TreeNode createTree(int[] preorder, int[] inorder) {
        
        // map for O(1) look up on index of in-order value
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        TreeNode root = createTreeRecur(preorder, inorder, 0, inorder.length - 1);
        map = new HashMap<>();  // reset static variables
        preIdx = 0;  // reset static variables

        return root;
    }
    
    public static TreeNode createTreeRecur(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        // First index of pre-order is always a root of tree
        // Starting from 0 to end of pre-order, construct node
        int preVal = preorder[preIdx];
        TreeNode node = new TreeNode(preVal);
        preIdx++;
        
        if (inStart == inEnd) {
            return node;
        }
        
        int inIdx = map.get(preVal);  // find position of value in in-order array
        
        node.left = createTreeRecur(preorder, inorder, inStart, inIdx - 1);  // left of inIdx
        node.right = createTreeRecur(preorder, inorder, inIdx + 1, inEnd);  // right of inIdx
        
        return node;
    }
}
