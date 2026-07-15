package Level2;
import java.util.Scanner;

public class BMIStatus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            double weight, height;
            while (true) {
                System.out.print("Enter weight of person " + (i + 1) + ": ");
                weight = sc.nextDouble();
                System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
                height = sc.nextDouble();
                if (weight > 0 && height > 0) break;
                System.out.println("Enter positive values only.");
            }
            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("Details of Persons:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + " -> Weight: " + personData[i][0] + ", Height: " + personData[i][1] + ", BMI: " + personData[i][2] + ", Status: " + weightStatus[i]);
        }
    }
}

