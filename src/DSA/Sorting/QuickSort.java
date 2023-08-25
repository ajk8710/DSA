package DSA.Sorting;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] myArr = new int[] {4, 7, 1, -4, 8, 3, 0 ,20, 1, 12};
        quickSort(myArr, 0, myArr.length - 1);
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
    
    // Choose pivot (as lowerbound or could be middle). Start i as lowerbound, j as upperbound.
    // Increment i until finding element bigger than pivot, Decrement j until finding element less than pivot. (or until they meets pivot).
    // Once both i and j stopped, swap i and j if i&j not crossed yet. Continue until i > j (crossed). Once crossed, swap j with pivot. Return what was position of j.
    // Repeat the process by partitioning on j.
    public static void quickSort(int[] arr, int i, int j) {
        if (i < j) {  // if i & j not crossed
            int pivot = partition(arr, i, j);
            quickSort(arr, i, pivot - 1);
            quickSort(arr, pivot + 1, j);
        }
    }
    
    // i is lowerbound, j is upperbound
    public static int partition(int[] arr, int i, int j) {
        int pivot = i;  // choosing new pivot be lowerbound
        
        while (i < j) {  // if i & j not crossed
            
            while (i < arr.length && arr[i] <= arr[pivot]) {  // Increment i until finding element bigger than pivot
                i++;
            }
            
            while (j >= 0 && arr[j] > arr[pivot]) {  // Decrement j until finding element less than pivot
                j--;
            }
            
            if (i < j) {  // swap if i & j still not crossed
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // swap pivot and j if i & j crossed
        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;
        
        return j;
    }
    
}
