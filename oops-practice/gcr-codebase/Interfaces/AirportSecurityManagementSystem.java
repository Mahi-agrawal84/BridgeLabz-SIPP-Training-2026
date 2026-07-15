// Interface 1
interface LuggageScanner {

    boolean scanLuggage(double luggageWeight);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage must not exceed the allowed limit.");
    }
}

// Interface 2
interface PassportVerifier {

    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passengers must carry a valid passport.");
    }

    // Static Method
    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.length() == 8;
    }
}

// Class implementing both interfaces
class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    @Override
    public boolean scanLuggage(double luggageWeight) {
        return luggageWeight <= 25.0; // Allowed limit = 25 kg
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    // Resolving default method conflict
    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void checkPassenger(String name,
                               String passportNo,
                               double luggageWeight) {

        boolean passportValid = verifyPassport(passportNo);
        boolean luggageValid = scanLuggage(luggageWeight);

        if (passportValid && luggageValid) {
            System.out.println(name + " -> Allowed to Board");
        } else {
            System.out.println(name + " -> Not Allowed to Board");
        }
    }
}

// Main Class
public class AirportSecurityManagementSystem {

    public static void main(String[] args) {

        String[] passengerNames = {
                "Rahul",
                "Aman",
                "Priya",
                "Neha"
        };

        String[] passportNumbers = {
                "AB123456",
                "P1234",
                "XY987654",
                "CD456789"
        };

        double[] luggageWeights = {
                20.5,
                30.0,
                22.0,
                28.5
        };

        AirportSecuritySystem security =
                new AirportSecuritySystem();

        System.out.println("Security Guidelines:");
        security.displaySecurityGuidelines();

        System.out.println("\nPassenger Verification:");

        for (int i = 0; i < passengerNames.length; i++) {
            security.checkPassenger(
                    passengerNames[i],
                    passportNumbers[i],
                    luggageWeights[i]
            );
        }
    }
}