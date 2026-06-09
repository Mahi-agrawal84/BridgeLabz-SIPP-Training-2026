package Level2;
import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double distanceInFeet = sc.nextDouble();
            double distanceInYards = distanceInFeet / 3;
            double distanceInMiles = distanceInYards / 1760;
            System.out.println("The distance in yards is " + distanceInYards + " while the distance in miles is " + distanceInMiles);
        }
    }
}

