package DSA.tree.problems;

import java.util.Arrays;
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
        
    }
    
    public static TreeNode createTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();  // in-order map(value, index)
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return createTreeRecur(preorder, inorder, map);
    }
    
    public static TreeNode createTreeRecur(int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        System.out.print("in: ");
        for (int i : preorder) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        TreeNode root = new TreeNode(preorder[0]);  // first index of pre-order is always a root of tree
        
        int mid = map.get(preorder[0]);  // find position of root in in-order array
        
        root.left = createTreeRecur(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid), map);
        root.right = createTreeRecur(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length), map);
        
        return root;
    }
}
