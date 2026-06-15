package Level3;
import java.util.*;

class BonusCalculator {
    public static int[][] getSalaryAndService(int n) {
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + (int)(Math.random() * 90000);
            data[i][1] = 1 + (int)(Math.random() * 10);
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(int[][] data) {
        double[][] result = new double[data.length][3];
        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus = years > 5 ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = salary;
            result[i][1] = newSalary;
            result[i][2] = bonus;
        }
        return result;
    }

    public static void displayTotals(double[][] result) {
        double sumOld = 0, sumNew = 0, sumBonus = 0;
        System.out.printf("%-10s %-15s %-15s %-15s%n", "EmpID", "Old Salary", "New Salary", "Bonus");
        for (int i = 0; i < result.length; i++) {
            sumOld += result[i][0];
            sumNew += result[i][1];
            sumBonus += result[i][2];
            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f%n", i + 1, result[i][0], result[i][1], result[i][2]);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s %-15.2f %-15.2f %-15.2f%n", "TOTAL", sumOld, sumNew, sumBonus);
    }
}

public class Mainss {
    public static void main(String[] args) {
        int[][] data = BonusCalculator.getSalaryAndService(10);
        double[][] result = BonusCalculator.calculateNewSalaryAndBonus(data);
        BonusCalculator.displayTotals(result);
    }
}

