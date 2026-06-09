package Level1;
public class VolumeEarth {
    public static void main(String[] args) {
        double radiusKm = 6378.0;

        double kmToMiles = 0.621371;
        
        double volumeKm = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        double radiusMiles = radiusKm * kmToMiles;
        double volumeMiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm +
                           " and cubic miles is " + volumeMiles);
    }
}
