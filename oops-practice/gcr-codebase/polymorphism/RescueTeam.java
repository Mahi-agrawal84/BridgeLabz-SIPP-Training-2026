public abstract class RescueTeam {
    protected String teamId;
    protected String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getLocation() {
        return location;
    }

    public abstract void performDuty();

    public static void main(String[] args) {
        RescueTeam[] teams = new RescueTeam[] {
                new MedicalTeam("M1", "Zone A"),
                new FireRescueTeam("F1", "Zone B"),
                new FoodSupplyTeam("S1", "Zone C")
        };

        for (RescueTeam team : teams) {
            team.performDuty();
        }
    }
}

class MedicalTeam extends RescueTeam {

    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Medical Team " + teamId +
                " is providing medical aid at " + location);
    }
}

class FireRescueTeam extends RescueTeam {

    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Fire Rescue Team " + teamId +
                " is extinguishing fires and rescuing people at " + location);
    }
}

class FoodSupplyTeam extends RescueTeam {

    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Food Supply Team " + teamId +
                " is distributing food at " + location);
    }
}