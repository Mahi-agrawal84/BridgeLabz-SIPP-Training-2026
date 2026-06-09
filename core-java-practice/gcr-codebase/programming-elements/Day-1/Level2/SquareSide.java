package Level2;
import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double perimeter = sc.nextDouble();
            double side = perimeter / 4;
            System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        }
    }
}

