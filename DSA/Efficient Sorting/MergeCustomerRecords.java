import java.util.Scanner;

public class MergeCustomerRecords {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n1 = sc.nextInt();
            int[] a = new int[n1];

            for (int i = 0; i < n1; i++)
                a[i] = sc.nextInt();

            int n2 = sc.nextInt();
            int[] b = new int[n2];

            for (int i = 0; i < n2; i++)
                b[i] = sc.nextInt();

            int i = 0;
            int j = 0;

            while (i < n1 && j < n2) {

                if (a[i] <= b[j])
                    System.out.print(a[i++] + " ");
                else
                    System.out.print(b[j++] + " ");
            }

            while (i < n1)
                System.out.print(a[i++] + " ");

            while (j < n2)
                System.out.print(b[j++] + " ");
        }
    }
}