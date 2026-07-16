import java.util.HashMap;

public class FraudPairDetection {

    public static int[] findFraudPair(int[] amounts, int target) {

        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {

            int complement = target - amounts[i];

            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            seen.put(amounts[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] amounts = {1200, 500, 700, 300, 800};
        int target = 1500;

        int[] result = findFraudPair(amounts, target);

        if (result[0] != -1) {
            System.out.println("Fraud Pair Found at Indices: " + result[0] + " " + result[1]);
        } else {
            System.out.println("No Fraud Pair Found");
        }
    }
}