// Interface 1
interface HeartRateMonitor {

    void displayHeartRate(int heartRate);

    default void displayHealthTips() {
        System.out.println("Tip: Exercise regularly to maintain a healthy heart.");
    }
}

// Interface 2
interface TemperatureMonitor {

    void displayTemperature(double temperature);

    default void displayHealthTips() {
        System.out.println("Tip: Stay hydrated and monitor body temperature.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.length() == 6;
    }
}

// Class implementing both interfaces
class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    @Override
    public void displayHeartRate(int heartRate) {
        System.out.println("Heart Rate: " + heartRate + " bpm");
    }

    @Override
    public void displayTemperature(double temperature) {
        System.out.println("Temperature: " + temperature + " °C");
    }

    // Resolve default method conflict
    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generateHealthReport(String name, String patientId,
                                     int heartRate, double temperature) {

        System.out.println("\nPatient: " + name);
        System.out.println("Patient ID: " + patientId);

        if (TemperatureMonitor.isPatientIdValid(patientId)) {
            System.out.println("ID Status: Valid");
        } else {
            System.out.println("ID Status: Invalid");
        }

        displayHeartRate(heartRate);
        displayTemperature(temperature);

        if (heartRate >= 60 && heartRate <= 100 &&
            temperature >= 36.1 && temperature <= 37.5) {
            System.out.println("Health Status: Normal");
        } else {
            System.out.println("Health Status: Needs Attention");
        }
    }
}

// Main Class
public class SmartHealthcareMonitoringSystem {

    public static void main(String[] args) {

        String[] patientNames = {
                "Rahul", "Priya", "Aman", "Neha"
        };

        String[] patientIds = {
                "P12345", "P56789", "1234", "P98765"
        };

        int[] heartRates = {
                72, 95, 110, 80
        };

        double[] temperatures = {
                36.8, 37.2, 38.5, 36.5
        };

        HealthMonitoringSystem system =
                new HealthMonitoringSystem();

        System.out.println("Health Tips:");
        system.displayHealthTips();

        System.out.println("\n===== HEALTH REPORT =====");

        for (int i = 0; i < patientNames.length; i++) {
            system.generateHealthReport(
                    patientNames[i],
                    patientIds[i],
                    heartRates[i],
                    temperatures[i]
            );
        }
    }
}