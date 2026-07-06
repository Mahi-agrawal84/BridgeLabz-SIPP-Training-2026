import java.util.Scanner;

public class BubbleSortSwapCount {

    public static int bubbleSort(int[] nums) {
        int swaps = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter array size: ");
            int n = sc.nextInt();

            int[] nums = new int[n];

            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int swapCount = bubbleSort(nums);

            System.out.println("Total Swaps: " + swapCount);
        }
    }
}