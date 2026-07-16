import java.util.*;

public class DetectiveAgency {

    public static void main(String[] args) {

        HashMap<String, List<String>> suspectCases = new HashMap<>();

        suspectCases.put("John", Arrays.asList("C1", "C2", "C3"));
        suspectCases.put("Alice", Arrays.asList("C1", "C2"));
        suspectCases.put("Bob", Arrays.asList("C2", "C3"));
        suspectCases.put("David", Arrays.asList("C4", "C5"));
        suspectCases.put("Emma", Arrays.asList("C4", "C5"));

        // Most investigated suspect
        findMostInvestigated(suspectCases);

        // Suspects in exactly 2 cases
        suspectsWithTwoCases(suspectCases);

        // Pairs always seen together
        findPairsSeenTogether(suspectCases);

        // Prefix Sum + HashMap
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;

        findSubarray(arr, k);
    }

    // Find suspect with maximum cases
    public static void findMostInvestigated(HashMap<String, List<String>> map) {

        String suspect = "";
        int max = 0;

        for (String key : map.keySet()) {
            if (map.get(key).size() > max) {
                max = map.get(key).size();
                suspect = key;
            }
        }

        System.out.println("Most Investigated Suspect: " + suspect);
    }

    // Find suspects appearing in exactly 2 cases
    public static void suspectsWithTwoCases(HashMap<String, List<String>> map) {

        System.out.println("\nSuspects in Exactly 2 Cases:");

        for (String key : map.keySet()) {
            if (map.get(key).size() == 2) {
                System.out.println(key);
            }
        }
    }

    // Find every pair of suspects having same case list
    public static void findPairsSeenTogether(HashMap<String, List<String>> map) {

        System.out.println("\nPairs Always Seen Together:");

        List<String> suspects = new ArrayList<>(map.keySet());

        for (int i = 0; i < suspects.size(); i++) {

            for (int j = i + 1; j < suspects.size(); j++) {

                List<String> list1 = new ArrayList<>(map.get(suspects.get(i)));
                List<String> list2 = new ArrayList<>(map.get(suspects.get(j)));

                Collections.sort(list1);
                Collections.sort(list2);

                if (list1.equals(list2)) {
                    System.out.println(suspects.get(i) + " - " + suspects.get(j));
                }
            }
        }
    }

    // Prefix Sum + HashMap
    public static void findSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (map.containsKey(sum - k)) {

                int start = map.get(sum - k) + 1;

                System.out.println("\nSubarray with Sum " + k +
                        " found from index " + start + " to " + i);
                return;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        System.out.println("\nNo Subarray Found");
    }
}