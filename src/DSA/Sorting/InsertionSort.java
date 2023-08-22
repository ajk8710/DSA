package DSA.Sorting;

public class InsertionSort {
    
    public static void main(String[] args) {
        int[] myArr = new int[] {4, 7, 1, -4, 8, 3, 0 ,20, 1, 12};
        insertionSort(myArr);
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
    
    // Starting from 2nd element, continuously move to front if it¡¯s smaller than the element in front of it.
    public static void insertionSort(int[] arr) {
        int numComparison = 0;

        for (int i = 0; i < arr.length - 1; i++) {  // arr.length - 1 because j = i + 1 below
            for (int j = i + 1; j > 0; j--) {  // starting from 2nd element, compare with what's in front of it.
                numComparison++;
                boolean swapped = false;
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
                if (!swapped) {  // if unswapped, what's in front of it is already sorted
                    break;
                }
            }
        }
        System.out.println("Num of Comparison: " + numComparison);

    }
    
}
