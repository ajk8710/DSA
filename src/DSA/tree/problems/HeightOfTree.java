package DSA.tree.problems;

import DSA.tree.BSTNode;
import DSA.tree.BinarySearchTree;

// Calculate the height of a binary tree
public class HeightOfTree {
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = new int[] {8, 5, 3, 8, 9, 1, 0, 7, 6, 8, 10, 2, 6};
        for (int i : arr) {
            tree.insertRecursive(i);
        }
        tree.printInorder();
        System.out.println(findHeight(tree.root));
        
    /*
            8
         5     8
       3   7      9
     1    6      8 10
    0 2    6
    */
    }
    
    public static int findHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }
        
        // 0 returns from leaf's child (null). Continue return while adding 1.
        int heightOfLeft = findHeight(node.left) + 1;
        int heightOfRight = findHeight(node.right) + 1;
        
        return Math.max(heightOfLeft, heightOfRight);
        
    }
}
