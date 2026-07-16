import java.util.HashMap;

public class MostFrequentErrorCode {

    public static int mostFrequentErrorCode(int[] codes) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {

            int count;

            if (freq.containsKey(code)) {
                count = freq.get(code) + 1;
                freq.put(code, count);
            } else {
                count = 1;
                freq.put(code, count);
            }

            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {

        int[] codes = {500, 404, 500, 200, 404, 500, 503, 500};

        int result = mostFrequentErrorCode(codes);

        System.out.println("Most Frequent Error Code: " + result);
    }
}