package Level3;
import java.util.Scanner;

public class CollinearCheck {
    static double slope(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) return Double.POSITIVE_INFINITY;
        return (double)(y2 - y1) / (x2 - x1);
    }

    static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = slope(x1, y1, x2, y2);
        double slopeBC = slope(x2, y2, x3, y3);
        return slopeAB == slopeBC;
    }

    static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        int x3 = sc.nextInt(), y3 = sc.nextInt();
        if (areCollinearBySlope(x1, y1, x2, y2, x3, y3))
            System.out.println("Collinear by slope method");
        else
            System.out.println("Not collinear by slope method");
        if (areCollinearByArea(x1, y1, x2, y2, x3, y3))
            System.out.println("Collinear by area method");
        else
            System.out.println("Not collinear by area method");
    }
}
