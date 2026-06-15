package Level3;
import java.util.Scanner;

public class MatrixOperations {
    static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int)(Math.random() * 10);
        return matrix;
    }

    static int[][] add(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    static int[][] subtract(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt(), c1 = sc.nextInt();
        int r2 = sc.nextInt(), c2 = sc.nextInt();
        int[][] A = createMatrix(r1, c1);
        int[][] B = createMatrix(r2, c2);
        System.out.println("Matrix A:");
        display(A);
        System.out.println("Matrix B:");
        display(B);
        if (r1 == r2 && c1 == c2) {
            System.out.println("Addition:");
            display(add(A, B));
            System.out.println("Subtraction:");
            display(subtract(A, B));
        }
        if (c1 == r2) {
            System.out.println("Multiplication:");
            display(multiply(A, B));
        }
    }
}
