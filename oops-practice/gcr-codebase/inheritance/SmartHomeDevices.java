// Superclass
class Device {
    protected String deviceId;
    protected String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    private final int temperatureSetting;

    public Thermostat(String deviceId, String status,
                      int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: "
                + temperatureSetting + "°C");
    }
}

// Main Class
public class SmartHomeDevices {
    public static void main(String[] args) {

        Thermostat thermostat =
                new Thermostat("TH101", "ON", 24);

        System.out.println("Thermostat Details:");
        thermostat.displayStatus();
    }
}