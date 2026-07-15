class SpaceTourist {

    // Static Variables
    static int totalReservations = 0;
    static String missionName = "Mars Explorer Mission";

    // Instance Variables
    String touristName;
    int seatNumber;

    // Constructor
    SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    // Method for method chaining
    SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this; // returns current object
    }

    // Display details
    void displayDetails() {
        System.out.println("Mission Name       : " + missionName);
        System.out.println("Tourist Name       : " + touristName);
        System.out.println("Final Seat Number  : " + seatNumber);
        System.out.println(" ");
    }
}

public class SpaceTourismReservationSystem {

    public static void main(String[] args) {

        // Create tourists
        SpaceTourist tourist1 = new SpaceTourist("Aman", 5);
        SpaceTourist tourist2 = new SpaceTourist("Priya", 8);
        SpaceTourist tourist3 = new SpaceTourist("Rahul", 12);

        // Method Chaining
        tourist1.updateSeatNumber(10)
                .updateSeatNumber(15);

        // Display final details
        tourist1.displayDetails();
        tourist2.displayDetails();
        tourist3.displayDetails();

        System.out.println("Total Reservations : "
                + SpaceTourist.totalReservations);
    }
}