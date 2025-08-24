public class HeapSortWithSteps {

    static int steps = 0; // to count number of steps

    // Main heap sort function
    public static void heapSort(int arr[]) {
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.println("\nMax Heap Built:");
        printArray(arr);

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            steps++;
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("Step " + steps + ": Swapped root with index " + i);
            printArray(arr);

            // Heapify reduced heap
            heapify(arr, i, 0);
        }

        System.out.println("\nTotal Steps: " + steps);
    }

    // To heapify a subtree rooted at index i
    public static void heapify(int arr[], int n, int i) {
        steps++;
        int largest = i; // root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            System.out.println("Heapify Step (root=" + i + "):");
            printArray(arr);

            heapify(arr, n, largest);
        }
    }

    // Helper function to print array
    public static void printArray(int arr[]) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        heapSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}

