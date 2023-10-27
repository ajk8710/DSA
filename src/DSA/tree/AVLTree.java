package DSA.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Single Rotation: Pivot is right (left) heavy & right (left) child is also right (left) heavy: same sign (+/-)
    If right (left) heavy, rotate left (right) on pivot: pivot goes down, child goes up
Double Rotation: Pivot is right (left) heavy & right (left) child is but, left (right) heavy: diff sign (+/-)
    Rotate on child first, to the other direction of pivot rotation.
Does child of pivot has Left/Right child:
    On Left Rotation:  has left child?  becomes right child of pivot after rotation
    On Right Rotation: has right child? becomes left child of pivot after rotation
*/
public class AVLTree {
    AVLNode root;
    
    public AVLTree() {
    }
    
    public void insert(int val) {
        root = insert(root, val);
    }
    
    public void delete(int val) {
        root = delete(root, val);
    }
    
    private int height(AVLNode node) {  // method to get height of a node, to handle "node == null" condition
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    private int balance(AVLNode node) {  // method to calculate balance of a node
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Do normal binary tree insertion. Go left or right until leaf is found. Insert as left or right of leaf.
    // Return node as updating height and calculating balance. If calculated balance of node is 2 or -2, balance the tree.
    private AVLNode insert(AVLNode node, int val) {
        
        // Normal binary tree insertion
        if (node == null) {  // terminate condition. Continue go left or right until null node is found. (child of leaf)
            node = new AVLNode(val);  // if null node found, create node with val and return
            return node;
        }
        
        if (val < node.val) {
            node.left = insert(node.left, val);  // either new node or original left node returns
        }
        else {
            node.right = insert(node.right, val);  // either new node or original right node returns
        }
        // Normal binary tree insertion is done. Before returning node, update height and calculate balance
        
        node.height = 1 + Math.max(height(node.left), height(node.right));  // update height
        
        int balance = balance(node);  // calculate balance
        
        if (balance >= 2) {  // node (pivot node) is left heavy
            if (balance(node.left) >= 0) {   // and left child is also left heavy
                return rightRotate(node);           // single rotate right on pivot
            }
            else {                                  // else, double rotate
                node.left = leftRotate(node.left);  // rotate left on left child
                return rightRotate(node);           // rotate right on pivot
            }
        }
        else if (balance <= -2) {  // node (pivot node) is right heavy
            if (balance(node.right) <= 0) {  // and right child is also right heavy
                return leftRotate(node);     // single rotate left on pivot
            }
            else {                                     // else, double rotate
                node.right = rightRotate(node.right);  // rotate right on right child
                return leftRotate(node);               // rotate left on pivot
            }
        }
        
        return node;  // return node, continue move toward root
    }
    
    //      R          l
    //   l     r  ->     R
    //    lr           lr  r
    private AVLNode rightRotate(AVLNode node) {
        AVLNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }
    
    //      R            r
    //   l     r  ->   R
    //       rl       l rl
    private AVLNode leftRotate(AVLNode node) {
        AVLNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }
    
    // Do normal binary tree deletion. Go left or right until node is found. Delete and replace with child if it has only one child.
    // If node to be deleted has two children, replace the node's value with in-order-successor. Then delete in-order-successor.
    // Return node as updating height and calculating balance. If calculated balance of node is 2 or -2, balance the tree.
    private AVLNode delete(AVLNode node, int val) {
        
        // Normal binary tree deletion
        if (node == null) {  // base case
            return null;
        }
        
        if (val < node.val) {  // go left
            node.left = delete(node.left, val);  // assign back what's updated
        }
        else if (val > node.val) {  // go right
            node.right = delete(node.right, val);  // assign back what's updated
        }
        else {  // found val
            if (node.left == null) {  // if has only right child (left == null)
                return node.right;    // return right. (If right is also null, just return null)
            }
            if (node.right == null) {  // if has only left child (right == null)
                return node.left;      // return left. (If left is also null, just return null)
            }
            
            // the node has both children
            AVLNode curr = node.right;   // find min of right subtree (in-order successor)
            while (curr.left != null) {  // by continue going left
                curr = curr.left;
            }
            node.val = curr.val;  // replace val with min (in-order successor)
            node.right = delete(node.right, curr.val);  // delete what was in-order successor
        }
        // Normal binary tree deletion is done. Before returning node, update height and calculate balance
        // Following codes are the same as insertion.
        
        node.height = 1 + Math.max(height(node.left), height(node.right));  // update height
        
        int balance = balance(node);  // calculate balance
        
        if (balance >= 2) {  // node (pivot node) is left heavy
            if (balance(node.left) >= 0) {   // and left child is also left heavy
                return rightRotate(node);           // single rotate right on pivot
            }
            else {                                  // else, double rotate
                node.left = leftRotate(node.left);  // rotate left on left child
                return rightRotate(node);           // rotate right on pivot
            }
        }
        else if (balance <= -2) {  // node (pivot node) is right heavy
            if (balance(node.right) <= 0) {  // and right child is also right heavy
                return leftRotate(node);     // single rotate left on pivot
            }
            else {                                     // else, double rotate
                node.right = rightRotate(node.right);  // rotate right on right child
                return leftRotate(node);               // rotate left on pivot
            }
        }
        
        return node;  // return node, continue move toward root
    }
    
    public void printInorder() {
        inorder(root);
        System.out.println();
    }
    
    private void inorder(AVLNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    
    public void printLevelOrder() {
        List<List<Integer>> levelOrderList = levelOrder(root);
        System.out.println(levelOrderList);
    }
    
    // Level Order Traversal is Breath First Search using Queue.
    // Push root to queue.
    // While queue is not null:
    //   For the current length of queue:
    //     Poll node from queue. Print the value of node.
    //     Push left then right child of node to queue. (these children are not the current level >= length of queue)
    // Repeat until queue is empty.
    private List<List<Integer>> levelOrder(AVLNode root) {
        List<List<Integer>> returnList = new LinkedList<>();  // return list
        
        if (root == null) {  // if root is null, return empty return list
            return returnList;
        }

        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);  // queue.add(null) prevented from above code
        
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<Integer>();  // list for current level
            
            int qLen = queue.size();  // for current level
            for (int i = 0; i < qLen; i++) {
                
                AVLNode node = queue.poll();  // poll nodes of current level
                level.add(node.val);
                
                if (node.left != null) {  // do not push null nodes to queue
                    queue.add(node.left);  // newly pushed nodes are not current level (i greater or equal than qLen)
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            // if (!level.isEmpty()) {  // queue.add(null) prevented. What's in queue is never null node, thus to be added to level list.
                returnList.add(level);  // i.e. if queue is not empty, there is node to be added to level list: No need for "if level not empty"
            // }
        }
        
        return returnList;
    }
    
}
