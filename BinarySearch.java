import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sorted array (binary search works only on sorted arrays)
        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        System.out.print("Enter the number to search: ");
        int target = sc.nextInt();

        int low = 0, high = arr.length - 1;
        int steps = 0;
        int result = -1;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                break; // found, stop
            } else if (arr[mid] < target) {
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }

        if (result == -1)
            System.out.println("Element not found. Steps = " + steps);
        else
            System.out.println("Element found at index " + result + " | Steps = " + steps);

        sc.close();
    }
}
