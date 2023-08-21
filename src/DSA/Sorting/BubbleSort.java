package DSA.Sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] myArr = new int[] {4, 7, 1, -4, 8, 3, 0 ,20, 1, 12};
        bubbleSort(myArr);
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
    
    // Go through the list from the beginning, swap with the next element if necessary.
    // Repeat from the beginning and swap until no more swap is necessary.
    // In result, array is sorted from the end.
    public static void bubbleSort(int[] arr) {
        
        int numComparison = 0;
        for (int i = 0; i < arr.length - 1; i++) {  // go through the list from beginning until no swap is necessary. This for-loop sets the boundary of a run through.
            boolean swapHappened = false;           //                                                                Boundary reduces from the end by j < arr.length - 1 - i
            
            for (int j = 0; j < arr.length - 1 - i; j++) {  // let's go and compare and swap
                numComparison++;
                
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapHappened = true;
                }
            }
            
            if (!swapHappened) {  // if no swap happened in a run, then array is sorted already, no more run necessary
                break;
            }
            
            // print to console for test purpose
            System.out.print("On run #" + i + ": ");
            for (int k : arr) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println("Num of Comparison: " + numComparison);
    }
}
