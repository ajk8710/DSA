package DSA.tree.problems;

import DSA.tree.BSTNode;
import DSA.tree.BinarySearchTree;

// Find the sum of leaf nodes of the tree
public class SumOfLeafNodes {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = new int[] {8, 5, 3, 8, 9, 1, 0, 7, 6, 8, 10, 2, 6};
        for (int i : arr) {
            tree.insertRecursive(i);
        }
        tree.printInorder();
        System.out.println(sumLeaves(tree.root));
        System.out.println(sumLeavesWithoutStaticVar(tree.root));
        
    /*
            8
         5     8
       3   7      9
     1    6      8 10
    0 2    6
    */
    }
    
    static int sum = 0;
    
    public static int sumLeaves(BSTNode root) {
        sumLeavesRecur(root);
        int mySum = sum;
        sum = 0;  // reset static variable
        return mySum;
    }
    
    // Continue to leaf, then add leaf's value to static variable
    public static void sumLeavesRecur(BSTNode node) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {  // if it's a leaf, add its value to static variable
            sum += node.val;
        }
        
        sumLeavesRecur(node.left);
        sumLeavesRecur(node.right);
        
    }
    
    // Another way, not using static variable
    public static int sumLeavesWithoutStaticVar(BSTNode node) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            return node.val;
        }
        
        int leftLeaf = sumLeavesWithoutStaticVar(node.left);    // 0 returns if child is null
        int rightLeaf = sumLeavesWithoutStaticVar(node.right);  // leaf value returns if child is leaf
        
        return leftLeaf + rightLeaf;
    }
    
    /*
            8
         5     8
       3   7      9
     1    6      8 10
    0 2    6
    */
    
}
