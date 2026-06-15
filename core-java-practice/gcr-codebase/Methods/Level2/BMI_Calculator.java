package Level2;
import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] statuses = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            statuses[i] = getBMIStatus(data[i][2]);
        }

        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + statuses[i]);
        }

        scanner.close();
    }

    public static double calculateBMI(double weight, double height) {
        double heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }

    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
