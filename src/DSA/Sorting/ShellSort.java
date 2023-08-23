package DSA.Sorting;

public class ShellSort {
    
    public static void main(String[] args) {
        int[] myArr = new int[] {4, 7, 1, -4, 8, 3, 0 ,20, 1, 12};
        shellSort(myArr);
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
    
    // Improved insertion sort - Compare distant element, not near element.
    // Take gap = n/2, upper index j = n/2, compare with lower index j - gap, then - gap, - gap.
    // Repeat while incrementing j until j < n, and then dividing gap by 2 until gap >= 1
    public static void shellSort(int[] arr) {
        int numComparison = 0;
        int n = arr.length;

        for (int gap = n/2; gap >= 1; gap /= 2) {  // until gap is 1 (when gap is 1, it's original insertion sort)
            for (int j = gap; j < n; j++) {  // j is upper index to compare with lower indexes i
                for (int i = j - gap; i >= 0; i -= gap) { // i is a gap distance in front of j
                    numComparison++;
                    if (arr[i + gap] < arr[i]) {  // use arr[i + gap] instead of arr[j] because j remains same within this for-loop
                        int temp = arr[i];
                        arr[i] = arr[i + gap];
                        arr[i + gap] = temp;
                    }
                    else {  // if unswapped, what's in front of it is already sorted
                        break;
                    }
                }
            }
        }
        System.out.println("Num of Comparison: " + numComparison);

    }
    
}
