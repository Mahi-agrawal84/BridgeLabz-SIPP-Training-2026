import java.util.Scanner;

public class StarBrightnessSearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static int searchRotated(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int findMinimum(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }

        return arr[low];
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of sorted array: ");
            int n = sc.nextInt();

            int[] sorted = new int[n];

            System.out.println("Enter sorted elements:");
            for (int i = 0; i < n; i++)
                sorted[i] = sc.nextInt();

            System.out.print("Enter target for Binary Search: ");
            int target = sc.nextInt();

            int index = binarySearch(sorted, target);
            System.out.println("Binary Search Index: " + index);

            System.out.print("Enter size of rotated array: ");
            int m = sc.nextInt();

            int[] rotated = new int[m];

            System.out.println("Enter rotated sorted elements:");
            for (int i = 0; i < m; i++)
                rotated[i] = sc.nextInt();

            System.out.print("Enter target in rotated array: ");
            int key = sc.nextInt();

            int rotatedIndex = searchRotated(rotated, key);
            System.out.println("Rotated Search Index: " + rotatedIndex);

            System.out.print("Enter target to find first and last occurrence: ");
            int value = sc.nextInt();

            int first = firstOccurrence(sorted, value);
            int last = lastOccurrence(sorted, value);

            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);

            int minimum = findMinimum(rotated);
            System.out.println("Minimum Element: " + minimum);
        }
    }
}