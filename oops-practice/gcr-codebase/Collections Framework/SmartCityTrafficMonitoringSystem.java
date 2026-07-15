import java.util.*;

public class SmartCityTrafficMonitoringSystem {

    public static void main(String[] args) {

        // HashMap to store road name and vehicle count
        HashMap<String, Integer> trafficData = new HashMap<>();

        // Adding/Updating vehicle counts
        trafficData.put("MG Road", 450);
        trafficData.put("Station Road", 720);
        trafficData.put("Ring Road", 980);
        trafficData.put("Airport Road", 610);
        trafficData.put("Civil Lines", 390);

        // Updating vehicle count
        trafficData.put("MG Road", 500);

        // Display total roads
        System.out.println("Total Roads Monitored: " + trafficData.size());

        // Display roads in sorted order using TreeMap
        System.out.println("\n Roads in Sorted Order ");
        TreeMap<String, Integer> sortedTraffic = new TreeMap<>(trafficData);

        for (Map.Entry<String, Integer> entry : sortedTraffic.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue() + " vehicles");
        }

        // Find busiest road
        String busiestRoad = "";
        int maxVehicles = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : trafficData.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }

        System.out.println("\n Busiest Road ");
        System.out.println("Road Name : " + busiestRoad);
        System.out.println("Vehicle Count : " + maxVehicles);

        // Traffic Analysis Report
        System.out.println("\n Traffic Analysis Report ");

        for (Map.Entry<String, Integer> entry : sortedTraffic.entrySet()) {

            String status;

            if (entry.getValue() >= 800) {
                status = "Heavy Traffic";
            } else if (entry.getValue() >= 500) {
                status = "Moderate Traffic";
            } else {
                status = "Low Traffic";
            }

            System.out.println("Road: " + entry.getKey());
            System.out.println("Vehicles: " + entry.getValue());
            System.out.println("Traffic Status: " + status);
            System.out.println("");
        }
    }
}