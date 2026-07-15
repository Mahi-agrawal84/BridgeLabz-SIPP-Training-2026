public class MovieReservation {
    // Array storing booked seat numbers
    static int[] seats = {101, 102, 103, 104, 105};
    public static int getSeat(int index) {
        try {
            // Attempt to access the array at the given index
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid access by catching the exception and returning -1
            return -1;
        }
    }

    public static void main(String[] args) {
        // Testing the scenario: requesting a seat at position 8
        int requestedIndex = 8;
        int result = getSeat(requestedIndex);
        
        System.out.println("Result for index " + requestedIndex + ": " + result);
    }
}