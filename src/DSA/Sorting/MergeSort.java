package DSA.Sorting;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] myArr = new int[] {4, 7, 1, -4, 8, 3, 0 ,20, 1, 12};
        mergeSort(myArr, 0, myArr.length - 1);
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
    
    public static void mergeSort(int[] arr, int low, int up) {  // lower bound & upper bound
        if (low < up) {
            int mid = (low + up) / 2;     // get middle
            mergeSort(arr, low, mid);     // continue to divide lower half until reaches to one element (low = up)
            mergeSort(arr, low + 1, up);  // continue to divide upper half until reaches to one element (low = up)
            merge(arr, low, mid, up);     // sort and merge halves
        }
    }
    
    public static void merge(int[] arr, int low, int mid, int up) {
        int i = low;      // i starts at lower bound (start of first half)
        int j = mid + 1;  // j starts at start of second half
        int k = low;
        
        int[] tempArr = new int [arr.length];  // create temp array

        while (i <= mid && j <= up) {
            if (arr[i] <= arr[j]) {
                tempArr[k] = arr[i];
                i++;
            }
            else {
                tempArr[k] = arr[j];
                j++;
            }
            k++;
        }
        
        // if (i > mid) {
            while (j <= up) {  // i is done, but j may not.
                tempArr[k] = arr[j];
                j++;
                k++;
            }
        // }
        // else {
            while (i <= mid) {  // j is done, but i may not.
                tempArr[k] = arr[i];
                i++;
                k++;
            }
        // }

        for (k = low; k <= up; k++) {  // copy & paste to original array
            arr[k] = tempArr[k];
        }
    }
}
