// Interface 1
interface Trackable {

    void logActivity();

    // Default method
    default void resetData() {
        System.out.println("Fitness data has been reset.");
    }
}

// Interface 2
interface Reportable {
    void generateReport();
}

// Interface 3
interface Notifiable {
    void sendAlert();
}

// Class implementing multiple interfaces
class FitnessDevice implements Trackable, Reportable, Notifiable {

    private final String userName;

    public FitnessDevice(String userName) {
        this.userName = userName;
    }

    @Override
    public void logActivity() {
        System.out.println(userName + " logged today's workout activity.");
    }

    @Override
    public void generateReport() {
        System.out.println("Generating fitness report for " + userName + ".");
    }

    @Override
    public void sendAlert() {
        System.out.println("Alert: Time for your next workout!");
    }
}

// Main Class
public class FitnessTracker {
    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice("Mahi");

        System.out.println("Fitness Tracker Functions:\n");

        device.logActivity();
        device.generateReport();
        device.sendAlert();

        // Calling default method from Trackable
        device.resetData();

        System.out.println("\nMultiple Interface Implementation Demonstrated.");
        System.out.println("FitnessDevice implements:");
        System.out.println("- Trackable");
        System.out.println("- Reportable");
        System.out.println("- Notifiable");
    }
}