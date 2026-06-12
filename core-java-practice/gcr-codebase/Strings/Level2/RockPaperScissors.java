package Level2;
import java.util.*;

public class RockPaperScissors {

    static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "draw";
        if (user.equals("rock") && computer.equals("scissors")) return "user";
        if (user.equals("scissors") && computer.equals("paper")) return "user";
        if (user.equals("paper") && computer.equals("rock")) return "user";
        return "computer";
    }

    static String[][] calculateStats(int userWins, int computerWins, int games) {
        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf((userWins * 100) / games) + "%";
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf((computerWins * 100) / games) + "%";
        return stats;
    }

    static void displayResults(List<String[]> gameResults, String[][] stats) {
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < gameResults.size(); i++) {
            String[] res = gameResults.get(i);
            System.out.println((i+1) + "\t" + res[0] + "\t" + res[1] + "\t\t" + res[2]);
        }
        System.out.println("\nStats:");
        System.out.println("Player\tWins\tWin%");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();
        int userWins = 0, computerWins = 0;
        List<String[]> gameResults = new ArrayList<>();
        for (int i = 0; i < games; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);
            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) computerWins++;
            gameResults.add(new String[]{userChoice, computerChoice, winner});
        }
        String[][] stats = calculateStats(userWins, computerWins, games);
        displayResults(gameResults, stats);
    }
}

