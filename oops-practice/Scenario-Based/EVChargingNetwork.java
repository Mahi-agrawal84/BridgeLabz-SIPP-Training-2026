class ChargingStation {

    // Static Variables
    static int totalStations = 0;
    static double electricityRate = 8.50; // Rate per unit

    // Instance Variables
    private final String stationId;
    private final double unitsConsumed;

    // Constructor
    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId; // using this keyword
        this.unitsConsumed = unitsConsumed;
        totalStations++; // increment total stations
    }

    // Method to calculate bill
    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    // Method to display station details
    public void displayStationDetails() {
        System.out.println("Station ID       : " + stationId);
        System.out.println("Units Consumed   : " + unitsConsumed);
        System.out.println("Electricity Rate : ₹" + electricityRate + " per unit");
        System.out.println("Bill Amount      : ₹" + calculateBill());
        System.out.println(" ");
    }
}

public class EVChargingNetwork {

    public static void main(String[] args) {

        // Create 5 charging stations
        ChargingStation s1 = new ChargingStation("CS101", 120);
        ChargingStation s2 = new ChargingStation("CS102", 150);
        ChargingStation s3 = new ChargingStation("CS103", 180);
        ChargingStation s4 = new ChargingStation("CS104", 200);
        ChargingStation s5 = new ChargingStation("CS105", 250);

        System.out.println(" Initial Bills ");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations Created: "
                + ChargingStation.totalStations);

        // Change electricity rate
        System.out.println("\nElectricity Rate Updated to ₹10.00 per unit\n");
        ChargingStation.electricityRate = 10.00;

        System.out.println(" Bills After Rate Change ");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}