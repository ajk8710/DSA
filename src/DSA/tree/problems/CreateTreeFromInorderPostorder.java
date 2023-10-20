package DSA.tree.problems;

import java.util.HashMap;

import DSA.tree.MyBinaryTree2;
import DSA.tree.TreeNode;

/*
Pre-order:  {1 2 4 8 9 10 11 5 3 6 7} 
In-order:   {8 4 10 9 11 2 5 1 6 3 7}
Post-order: {8 10 11 9 4 5 2 6 7 3 1}
*/
public class CreateTreeFromInorderPostorder {
    
    public static void main(String[] args) {
        int[] postorder = new int[] {8, 10, 11, 9, 4, 5, 2, 6, 7, 3, 1};
        int[] inorder = new int[] {8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7};
        
        TreeNode root = createTree(postorder, inorder);
        MyBinaryTree2 tree = new MyBinaryTree2(root);
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
    }
    
    static HashMap<Integer, Integer> map = new HashMap<>();  // in-order map(value, index)
    static int postIdx;  // index of post-order
    
    public static TreeNode createTree(int[] postorder, int[] inorder) {
        postIdx = postorder.length - 1;  // initialize postIdx
        
        // map for O(1) look up on index of in-order value
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        TreeNode root = createTreeRecur(postorder, inorder, 0, inorder.length - 1);
        map = new HashMap<>();  // reset static variable
        
        return root;
    }
    
    public static TreeNode createTreeRecur(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int postVal = postorder[postIdx];
        TreeNode node = new TreeNode(postVal);
        postIdx--;
        
        if (inStart == inEnd) {
            return node;
        }
        
        int inIdx = map.get(postVal);  // find position of value in in-order array
        
        // I'm going through post-order array from end to start. Postorder is left, right, root. So I need to build right subtree first then left.
        node.right = createTreeRecur(postorder, inorder, inIdx + 1, inEnd);  // "right of inIdx" to "inEnd of this call"
        node.left = createTreeRecur(postorder, inorder, inStart, inIdx - 1);  // "inStart of this call" to "left of inIdx"
        
        return node;
    }
}
