public class QuizApplication {
    public static void main(String[] args) {
        String[] answers = {"A", "B", "C", "D"};

        // Iterate through an extended range to demonstrate error handling
        for (int i = 0; i <= 5; i++) {
            try {
                // Task: Compare answers and handle potential exceptions
                if (answers[i] != null && answers[i].equals("A")) {
                    System.out.println("Match found at index " + i);
                } else {
                    System.out.println("No match at index " + i);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index " + i + " is out of bounds.");
            } catch (NullPointerException e) {
                System.out.println("Error: Null value encountered at index " + i);
            }
        }
    }
}