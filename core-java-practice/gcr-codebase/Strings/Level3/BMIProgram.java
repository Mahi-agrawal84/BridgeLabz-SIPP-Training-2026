package Level3;
import java.util.Scanner;

public class BMIProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hw = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            hw[i][1] = sc.nextDouble();
        }
        String[][] result = computeBMI(hw);
        display(result);
    }

    static String[][] computeBMI(double[][] hw) {
        String[][] res = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = hw[i][0];
            double height = hw[i][1] / 100;
            double bmi = weight / (height * height);
            String status;
            if (bmi <= 18.4) status = "Underweight";
            else if (bmi <= 24.9) status = "Normal";
            else if (bmi <= 39.9) status = "Overweight";
            else status = "Obese";
            res[i][0] = String.valueOf(weight);
            res[i][1] = String.valueOf(hw[i][1]);
            res[i][2] = String.format("%.2f", bmi);
            res[i][3] = status;
        }
        return res;
    }

    static void display(String[][] arr) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (String[] row : arr) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }
}
