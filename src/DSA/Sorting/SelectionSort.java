package DSA.Sorting;

public class SelectionSort {
    
    public static void main(String[] args) {
        int[] myArr = new int[] {4, 7, 1, -4, 8, 3, 0 ,20, 1, 12};
        selectionSort(myArr);
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
    
    // Go through the list from the beginning, find minimum, then bring to the front. Repeat.
    // In result, array is sorted from the beginning
    public static void selectionSort(int[] arr) {
        int numComparison = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {  // go through the list from beginning. This for-loop sets the boundary of a run through.
                                                    //                                     Boundary reduces from the beginning.
            int minIndex = i;
            int min = arr[i];
            
            for (int j = i + 1; j < arr.length; j++) {  // find the minimum among the rest (within boundary)
                numComparison++;
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            
            int temp = arr[i];  // once minimum is found, swap with beginning of the boundary
            arr[i] = min;
            arr[minIndex] = temp;
            
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
