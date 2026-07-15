package Level3;
import java.util.*;

public class StudentScorecard {
    static int[][] generateScores(int n) {
        Random r = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = r.nextInt(41) + 60;
            }
        }
        return scores;
    }

    static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3];
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = (double) total / 3;
            double perc = (double) total / 300 * 100;
            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return results;
    }

    static void display(int[][] scores, double[][] results) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPerc");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t");
            System.out.print((int)results[i][0] + "\t" + results[i][1] + "\t" + results[i][2]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        display(scores, results);
    }
}