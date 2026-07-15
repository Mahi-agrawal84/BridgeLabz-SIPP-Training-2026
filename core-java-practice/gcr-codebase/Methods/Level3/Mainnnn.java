package Level3;
import java.util.*;

class NumChecke {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }

    public static int getGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) if (f > max) max = f;
        return max;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static long productOfCubes(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= (long)Math.pow(f, 3);
        return prod;
    }
}

public class Mainnnn{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] factors = NumChecke.getFactors(num);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + NumChecke.getGreatestFactor(factors));
        System.out.println("Sum of Factors: " + NumChecke.sumOfFactors(factors));
        System.out.println("Product of Factors: " + NumChecke.productOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + NumChecke.productOfCubes(factors));
    }
}

