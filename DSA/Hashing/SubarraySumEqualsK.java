import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySumEqualsK(int[] revenueChanges, int k) {

        HashMap<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {

            runningSum += change;

            if (prefixCount.containsKey(runningSum - k)) {
                answer += prefixCount.get(runningSum - k);
            }

            if (prefixCount.containsKey(runningSum)) {
                prefixCount.put(runningSum, prefixCount.get(runningSum) + 1);
            } else {
                prefixCount.put(runningSum, 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] revenueChanges = {3, 4, -7, 1, 3, 3, 1, -4};

        int k = 0;

        int result = subarraySumEqualsK(revenueChanges, k);

        System.out.println("Number of Subarrays with Sum " + k + ": " + result);
    }
}