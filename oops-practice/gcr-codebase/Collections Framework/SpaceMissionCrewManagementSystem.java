import java.util.*;

public class SpaceMissionCrewManagementSystem {

    public static class Astronaut {
        private final String astronautId;
        private final String name;
        private final String specialization;

        public Astronaut(String astronautId, String name, String specialization) {
            this.astronautId = astronautId;
            this.name = name;
            this.specialization = specialization;
        }

        public String getAstronautId() {
            return astronautId;
        }

        @Override
        public String toString() {
            return "ID: " + astronautId +
                   ", Name: " + name +
                   ", Specialization: " + specialization;
        }
    }

    // Mission -> List of Astronauts
    private final HashMap<String, List<Astronaut>> missions = new HashMap<>();

    // Mission -> Set of Astronaut IDs (to prevent duplicates)
    private final HashMap<String, HashSet<String>> assignedIds = new HashMap<>();

    // Add Mission
    public void addMission(String missionName) {
        if (missions.containsKey(missionName)) {
            System.out.println("Mission already exists.");
        } else {
            missions.put(missionName, new ArrayList<>());
            assignedIds.put(missionName, new HashSet<>());
            System.out.println("Mission added successfully.");
        }
    }

    // Assign Astronaut
    public void assignAstronaut(String missionName, Astronaut astronaut) {

        if (!missions.containsKey(missionName)) {
            System.out.println("Mission not found.");
            return;
        }

        HashSet<String> ids = assignedIds.get(missionName);

        if (ids.contains(astronaut.getAstronautId())) {
            System.out.println("Astronaut already assigned to this mission.");
        } else {
            missions.get(missionName).add(astronaut);
            ids.add(astronaut.getAstronautId());
            System.out.println("Astronaut assigned successfully.");
        }
    }

    // Display Missions
    public void displayMissions() {

        if (missions.isEmpty()) {
            System.out.println("No missions available.");
            return;
        }

        System.out.println("\n Mission Details ");

        for (String mission : missions.keySet()) {

            System.out.println("\nMission: " + mission);

            List<Astronaut> crew = missions.get(mission);

            if (crew.isEmpty()) {
                System.out.println("No astronauts assigned.");
            } else {
                for (Astronaut a : crew) {
                    System.out.println(a);
                }
            }

            System.out.println("Total Astronauts: " + crew.size());
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            SpaceMissionCrewManagementSystem system =
                    new SpaceMissionCrewManagementSystem();

            int choice;

            do {
                System.out.println("\n Space Mission Crew Management System ");
                System.out.println("1. Add Mission");
                System.out.println("2. Assign Astronaut");
                System.out.println("3. Display Missions");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Mission Name: ");
                        String mission = sc.nextLine();
                        system.addMission(mission);
                    }
                    case 2 -> {
                        System.out.print("Enter Mission Name: ");
                        String mission = sc.nextLine();

                        System.out.print("Enter Astronaut ID: ");
                        String id = sc.nextLine();

                        System.out.print("Enter Astronaut Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Specialization: ");
                        String specialization = sc.nextLine();

                        Astronaut astronaut = new Astronaut(id, name, specialization);
                        system.assignAstronaut(mission, astronaut);
                    }
                    case 3 -> system.displayMissions();
                    case 4 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid Choice!");
                }

            } while (choice != 4);
        }
    }
}