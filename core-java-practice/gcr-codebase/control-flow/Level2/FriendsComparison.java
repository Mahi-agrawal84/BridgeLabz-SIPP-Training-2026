package Level2;
import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();
        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();
        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();

        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Youngest: Amar");
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            System.out.println("Youngest: Akbar");
        } else {
            System.out.println("Youngest: Anthony");
        }

        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Tallest: Amar");
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            System.out.println("Tallest: Akbar");
        } else {
            System.out.println("Tallest: Anthony");
        }
    }
}
