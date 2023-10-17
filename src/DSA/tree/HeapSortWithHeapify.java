package DSA.tree;

public class HeapSortWithHeapify {
    
    // helper method to swap
    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    // Max Heapify moves down passed index (root) into the correct position of max heap.
    public static void maxHeapify(int[] arr, int length, int idx) {
        int idxOfLargest = idx;        // initialize index of largest as index
        int idxOfLeft = 2 * idx + 1;   // index of left child
        int idxOfRight = 2 * idx + 2;  // index of right child
        
        if (idxOfLeft < length && arr[idxOfLeft] > arr[idxOfLargest]) {  // if there's left child, compare
            idxOfLargest = idxOfLeft;
        }
        if (idxOfRight < length && arr[idxOfRight] > arr[idxOfLargest]) {  // if there's right child, compare
            idxOfLargest = idxOfRight;
        }
        
        if (idxOfLargest != idx) {         // if there is an update to largest
            swap(arr, idxOfLargest, idx);  // swap child and parent
            maxHeapify(arr, length, idxOfLargest);  // keep going down the tree and compare
        }
    }
    
    // Heapify starting from leaf nodes to root: this converts array (normal complete binary tree) to max heap.
    // Delete root from max heap but instead of delete, swap root with last leaf (last index).
    // Consider last leaf as sorted. Continue on with arr.length minus sorted indexes.
    public static void heapSort(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {  // leaf nodes are already heap by itself.  So start from length / 2 - 1.
            maxHeapify(arr, length, i);
        }
        // at this point, arr is converted to max heap
        
        for (int i = length - 1; i >= 0; i--) {  // starting from last index to root
            swap(arr, 0, i);  // swap root and unsorted last index ('i' passed here as index)
            maxHeapify(arr, i, 0);  // since root changed, heapify again on root. Make sure not to consider sorted indexes ('i' here passed as length, not index).
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        heapSort(arr, 5);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        arr = new int[] {5, 4, 3, 2, 1};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        heapSort(arr, 5);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        arr = new int[] {3, 1, 2, 5, 4, 0};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        heapSort(arr, 6);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        arr = new int[] {3, 1, 0};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        heapSort(arr, 3);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
    
}
