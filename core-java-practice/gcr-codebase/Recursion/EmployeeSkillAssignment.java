import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeSkillAssignment {

    static void findTeams(int[] skills, int target, int index,
                          ArrayList<Integer> currentTeam, int currentSum) {

        // If target is reached, print the team
        if (currentSum == target) {
            System.out.println(currentTeam);
            return;
        }

        // Stop if sum exceeds target or end of array is reached
        if (index == skills.length || currentSum > target) {
            return;
        }

        // Include current employee
        currentTeam.add(skills[index]);
        findTeams(skills, target, index + 1,
                  currentTeam, currentSum + skills[index]);

        // Backtrack: exclude current employee
        currentTeam.remove(currentTeam.size() - 1);
        findTeams(skills, target, index + 1,
                  currentTeam, currentSum);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();

            int[] skills = new int[n];

            System.out.println("Enter skill scores:");
            for (int i = 0; i < n; i++) {
                skills[i] = sc.nextInt();
            }

            System.out.print("Enter target skill score: ");
            int target = sc.nextInt();

            System.out.println("Possible Teams:");
            findTeams(skills, target, 0, new ArrayList<>(), 0);
        }
    }
}