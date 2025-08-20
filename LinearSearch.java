public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        int steps = 0; 
        for (int i = 0; i < arr.length; i++) {
            steps++; 
            if (arr[i] == target) {
                System.out.println("Total steps taken: " + steps);
                return i; 
            }
        }

        System.out.println("Total steps taken: " + steps);
        return -1; 
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 50;

        int result = linearSearch(numbers, target);

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
