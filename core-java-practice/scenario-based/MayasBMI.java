import java.util.Scanner;

public class MayasBMI {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter weight (kg): ");
            double weight = scanner.nextDouble();
            
            System.out.print("Enter height (m): ");
            double height = scanner.nextDouble();

            double bmi = weight / (height * height);

            // Display BMI
            System.out.printf("BMI = %.2f%n", bmi);

            // Determine BMI category
            if (bmi < 18.5) {
                System.out.println("Category: Underweight");
            } else if (bmi < 25) {
                System.out.println("Category: Normal");
            } else {
                System.out.println("Category: Overweight");
            }
        }
    }
}