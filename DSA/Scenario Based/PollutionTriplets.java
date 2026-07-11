import java.util.*;

public class PollutionTriplets {

    public static List<List<Integer>> threeSum(int[] pollution) {

        Arrays.sort(pollution);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < pollution.length - 2; i++) {

            if (i > 0 && pollution[i] == pollution[i - 1])
                continue;

            int left = i + 1;
            int right = pollution.length - 1;

            while (left < right) {

                int sum = pollution[i] + pollution[left] + pollution[right];

                if (sum == 0) {
                    result.add(Arrays.asList(pollution[i], pollution[left], pollution[right]));

                    while (left < right && pollution[left] == pollution[left + 1])
                        left++;

                    while (left < right && pollution[right] == pollution[right - 1])
                        right--;

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] pollution = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ans = threeSum(pollution);

        for (List<Integer> triplet : ans) {
            System.out.println(triplet);
        }
    }
}