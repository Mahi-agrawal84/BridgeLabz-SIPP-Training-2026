import java.util.HashSet;
import java.util.Set;

public class DuplicateSessionTokenDetection {

    public static boolean hasDuplicateToken(String[] tokens) {

        Set<String> seen = new HashSet<>();

        for (String token : tokens) {

            if (!seen.add(token)) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        String[] tokens1 = {
                "TK101",
                "TK102",
                "TK103",
                "TK104"
        };

        String[] tokens2 = {
                "TK101",
                "TK102",
                "TK103",
                "TK102",
                "TK105"
        };

        System.out.println("Tokens1 has duplicate: " + hasDuplicateToken(tokens1));
        System.out.println("Tokens2 has duplicate: " + hasDuplicateToken(tokens2));
    }
}