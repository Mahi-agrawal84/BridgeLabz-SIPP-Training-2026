package Level1;
import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        double distanceInYards = distanceInFeet / 3.0;
        double distanceInMiles = distanceInYards / 1760.0;
        
        System.out.println("The distance in yards is " + distanceInYards + " and in miles is " + distanceInMiles + " for the given " + distanceInFeet + " feet");
        
        input.close();
    }
}
