import java.util.*;

class p14{
    static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if target is present at mid
            if (array[mid] == target)
                return mid;

            // If target is greater, ignore left half
            if (array[mid] < target)
                left = mid + 1;

            // If target is smaller, ignore right half
            else
                right = mid - 1;
        }

        // Element not present
        return -1;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of elements in the array: ");
        int size = input.nextInt();

        int[] array = new int[size];

        System.out.println("Enter elements in sorted order: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        System.out.println("Enter element to search: ");
        int target = input.nextInt();

        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in array");
        }
    }
}

