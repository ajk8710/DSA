package DSA.tree.assessment;

/*
You are given a tree as an array of integers that represent complete binary tree.
The root of tree is always -1.

Find the minimum root of subtree that is Divisible Tree.
Divisible Tree is a binary tree in which every non-leaf node is divisible by its child nodes,
and every node should have a positive value.
A single node is not a divisible tree.

Return the value of minimum root.
If there is no divisible tree, return -1.

Sample Input: {-1, 4, 4, 2, 1}
Sample Output: 4
*/
public class MinimumRootOfDivisibleTree {
    
    public static void main(String[] args) {
        int[] tree = new int[] {-1, 4, 4, 2, 1};
        System.out.println("{-1, 4, 4, 2, 1}: " + findMinRootOfDivisibleTree(tree));
        tree = new int[] {-1, 4, 6, 2, 1, 3, 2, 5};
        System.out.println("{-1, 4, 6, 2, 1, 3, 2, 5}: " + findMinRootOfDivisibleTree(tree));
    }
    
    // Start from index 1 to last non-leaf node (n-1)/2,
    // See if subtree as the index as root is divisible tree. If so update minimum.
    public static int findMinRootOfDivisibleTree(int[] tree) {    
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= (tree.length - 1) / 2; i++) {
            if (isDivisibleTree(tree, i)) {
                min = Math.min(min, tree[i]);
            }
        }
        
        if (min == Integer.MAX_VALUE) return -1;  // if minimum not updated, return -1
        return min;
    }
    
    // See if node as root is divisible tree
    public static boolean isDivisibleTree(int[] tree, int nodeIdx) {
        // If leaf node, return true. No need to run test.
        if (nodeIdx > (tree.length - 1) / 2) return true;
        
        if ( !isDivisibleByItsChildren(tree, nodeIdx) ) {  // run test on me
            return false;
        }
        
        int leftIdx = 2 * nodeIdx + 1;   // left child
        int rightIdx = 2 * nodeIdx + 2;  // right child
        
        return isDivisibleTree(tree, leftIdx) && isDivisibleTree(tree, rightIdx);  // run test on my children
    }
    
    // See if the node is divisible by both of its left & right child, if child exists
    public static boolean isDivisibleByItsChildren(int[] tree, int nodeIdx) {
        int leftIdx = 2 * nodeIdx + 1;   // left child
        int rightIdx = 2 * nodeIdx + 2;  // right child
        
        // if there is left (right) child, and the node is not divisible by child, return false
        if (leftIdx < tree.length && tree[nodeIdx] % tree[leftIdx] != 0) return false;
        if (rightIdx < tree.length && tree[nodeIdx] % tree[rightIdx] != 0) return false;
        
        return true;
    }

/*
           1
         4   6
        2 1 3 2
       5
4 is divisible by 2 and 1, but 2 is not divisible by 5.
Thus 4 as root of subtree is not divisible tree.
6 is divisible by 3 and 2. 6 as root of subtree is divisible tree.
*/
    
}
