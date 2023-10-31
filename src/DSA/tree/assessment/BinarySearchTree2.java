package DSA.tree.assessment;

/*
Create and add the following methods in BinarySearchTree
1. find_min(): finds minimum element in entire binary tree
2. find_max(): finds maximum element in entire binary tree
3. calculate_sum(): calculates sum of all elements
*/
public class BinarySearchTree2 {
    public BSTNode root;
    
    private int min;
    private int max;
    private int sum;
    
    public Integer findMin() {
        if (root == null) {
            return null;
        }
        min = root.val;
        updateMin(root);
        return min;
    }
    
    public void updateMin(BSTNode node) {
        if (node == null) return;
        if (node.val < min) min = node.val;
        updateMin(node.left);
        updateMin(node.right);
    }
    
    public Integer findMax() {
        if (root == null) {
            return null;
        }
        max = root.val;
        updateMax(root);
        return max;
    }
    
    public void updateMax(BSTNode node) {
        if (node == null) return;
        if (node.val > max) max = node.val;
        updateMax(node.left);
        updateMax(node.right);
    }
    
    public Integer calculateSum() {
        if (root == null) {
            return 0;
        }
        sum = 0;
        updateSum(root);
        return sum;
    }
    
    public void updateSum(BSTNode node) {
        if (node == null) return;
        sum += node.val;
        updateSum(node.left);
        updateSum(node.right);
    }
    
    public void insertIterative(int val) {
        if (root == null) {
            root = new BSTNode(val);
        }
        else {
            insertIter(root, val);
        }
    }
    
    private void insertIter(BSTNode node, int val) {
        if (val < node.val) {  // if less than the node
            if (node.left == null) {  // if left is null, create new node as the left
                node.left = new BSTNode(val);
                return;
            }
            else {
                insertIter(node.left, val);  // if left is not null, go compare with left. Recursive portion of iterative method
            }
        }
        else {  // if equal or greater than the node
            if (node.right == null) {  // if right is null, create new node as the right
                node.right = new BSTNode(val);
                return;
            }
            else {
                insertIter(node.right, val);  // if right is not null, go compare with right. Recursive portion of iterative method
            }
        }
    }
    
    public void insertRecursive(int val) {
        root = insertRecur(root, val);
    }
    
    private BSTNode insertRecur(BSTNode node, int val) {
        if (node == null) {  // terminate condition. Continue go left or right until null node is found.
            node = new BSTNode(val);  // if null node found, create node with val and return
            return node;
        }
        
        if (val < node.val) {
            node.left = insertRecur(node.left, val);  // either new node or original left node returns
            return node;
        }
        else {
            node.right = insertRecur(node.right, val);  // either new node or original right node returns
            return node;
        }
    }
    
    // Delete: Solve recursively.
    // Find a node with val.
    // If the node has no child, return null. So that it's parents child pointer is assigned null.
    // If the node has one child, return child. So that it's parent's child pointer is assigned the node's child.
    // If the node has two child. Find In-Order-Successor (minimum of right subtree).
    //   To find minimum, keep going left, until left is null.
    //   Once found minimum, replace val with minimum val. The minimum node must have no child or one child (right)
    //   Delete node using first two cases (no child or one child case) -> this is deliberately done by calling delete(minimum val).
    public void delete(int val) {
        root = deleteNode(root, val);
    }
    
    private BSTNode deleteNode(BSTNode node, int val) {
        if (node == null) {  // base case
            return null;
        }
                                                // delete 3
        if (val < node.val) {  // go left       //     1    go left
            node.left = deleteNode(node.left, val);  //   2   5  go left
        }                                       //  3 4     3 found
        else if (val > node.val) {  // go right
            node.right = deleteNode(node.right, val);  // assign back what's updated
        }
        else {  // found val
            if (node.left == null) {  // if has only right child (left == null)
                return node.right;    // return right. (If right is also null, just return null)
            }
            if (node.right == null) {  // if has only left child (right == null)
                return node.left;      // return left. (If left is also null, just return null)
            }
            
            // the node has both children
            BSTNode curr = node.right;  // find min of right subtree
            while (curr.left != null) {
                curr = curr.left;
            }
            node.val = curr.val;  // replace val with min (in-order successor)
            node.right = deleteNode(node.right, curr.val);  // delete what was in-order successor
        }
        
        return node;  // return updated root
    }
    
    public void printInorder() {
        inorder(root);
        System.out.println();
    }
    
    private void inorder(BSTNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    
    public void printPreorder() {
        preorder(root);
        System.out.println();
    }
    
    private void preorder(BSTNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
    
    public void printPostorder() {
        postorder(root);
        System.out.println();
    }
    
    private void postorder(BSTNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }
}
