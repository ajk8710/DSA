package DSA.tree.assessment;

// Testing findMin, findMax, calculateSum
public class BinarySearchTree2Test {

    public static void main(String[] args) {
        BinarySearchTree2 tree = new BinarySearchTree2();
        int[] arr = new int[] {8, 5, 3, 8, 9, 1, 0, 7, 6, 8, 10, 2, 6};
        for (int i : arr) {
            tree.insertIterative(i);
        }
        tree.printInorder();
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Sum: " + tree.calculateSum());
        
        tree = new BinarySearchTree2();
        arr = new int[] {15, 12, 7, 14, 27, 20, 23, 88};
        for (int i : arr) {
            tree.insertIterative(i);
        }
        tree.printInorder();
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Sum: " + tree.calculateSum());
        
    }

}

/*
             8
          5     8
        3   7      9
      1    6      8 10
     0 2    6
*/
