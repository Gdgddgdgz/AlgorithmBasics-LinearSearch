//Runtime complexity O(nlogn)---quasilnear time---quicksort,mergesort,heapsort 
//space complexity O(n)
public class MergeSortWithSteps {

    // Function to merge two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        System.out.println("Merging: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, left, right + 1)));

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge temp arrays back into arr
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("After merge: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, left, right + 1)));
    }

    // Recursive MergeSort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            System.out.println("Dividing: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, left, right + 1)));

            mergeSort(arr, left, mid);      // Sort left half
            mergeSort(arr, mid + 1, right); // Sort right half

            merge(arr, left, mid, right);   // Merge the two halves
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }
}

