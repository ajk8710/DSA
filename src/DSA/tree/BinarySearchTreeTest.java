package DSA.tree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = new int[] {8, 5, 3, 8, 9, 1, 0, 7, 6, 8, 10, 2, 6};
        for (int i : arr) {
            tree.insertIterative(i);
        }
        tree.printInorder();
        tree.printPreorder();
        tree.printPostorder();
        
        System.out.println();
        tree = new BinarySearchTree();
        for (int i : arr) {
            tree.insertRecursive(i);
        }
        tree.printInorder();
        tree.printPreorder();
        tree.printPostorder();
        
        System.out.println();
        tree = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                tree.insertIterative(arr[i]);
            }
            else {
                tree.insertRecursive(arr[i]);
            }
            
        }
        tree.printInorder();
        tree.printPreorder();
        tree.printPostorder();
        System.out.println();
        
        System.out.println("Delete 3: ");
        tree.delete(3);
        tree.printInorder();
        System.out.println("Delete 6: ");
        tree.delete(6);
        tree.printInorder();
        System.out.println("Delete 0: ");
        tree.delete(0);
        tree.printInorder();
        System.out.println("Delete 10: ");
        tree.delete(10);
        tree.printInorder();
        
    }

}

/*
             8
          5     8
        3   7      9
      1    6      8 10
     0 2    6
*/
