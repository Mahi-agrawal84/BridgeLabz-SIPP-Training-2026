package Level2;
import java.util.*;

public class StudentGrades {
    static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                scores[i][j] = 40 + rand.nextInt(61);
        return scores;
    }

    static String getGrade(int percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    static void displayScorecard(int[][] scores) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-15s %-10s%n",
                "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        for (int[] score : scores) {
            int total = score[0] + score[1] + score[2];
            double avg = Math.round(total / 3.0);
            int percentage = (int) Math.round((total / 300.0) * 100);
            String grade = getGrade(percentage);
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-15d %-10s%n",
                    score[0], score[1], score[2], total, avg, percentage, grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        displayScorecard(scores);
    }
}
