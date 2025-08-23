public class QuickSortWithSteps {

    // Partition function (Lomuto partition scheme)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing the last element as pivot
        System.out.println("Pivot chosen: " + pivot + " from " +
                           java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, low, high + 1)));

        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot into correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        System.out.println("After partition: " +
                           java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, low, high + 1)) +
                           " | Pivot placed at index " + (i + 1));

        return i + 1; // Return partition index
    }

    // QuickSort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            System.out.println("Sorting: " +
                               java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, low, high + 1)));

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Left side
            quickSort(arr, pi + 1, high); // Right side
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }
}
