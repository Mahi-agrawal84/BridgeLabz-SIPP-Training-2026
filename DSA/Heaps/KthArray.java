package Training.DSA.Heaps;

import java.util.Arrays;

public class KthArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        KthArray sol = new KthArray();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int ans = sol.findKthLargest(nums, k);
        System.out.println("Kth Largest Element = " + ans);
    }
}
