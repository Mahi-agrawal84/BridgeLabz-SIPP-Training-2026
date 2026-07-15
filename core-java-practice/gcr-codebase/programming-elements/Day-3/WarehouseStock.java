import java.util.*;

public class WarehouseStock {
    public static void main(String[] args) {

        // Stock quantities
        int[] stock = {50, 20, 80, 20, 40, 80, 60};

        // Max, Min, Total
        int max = stock[0];
        int min = stock[0];
        int total = 0;

        for (int qty : stock) {
            if (qty > max)
                max = qty;
            if (qty < min)
                min = qty;
            total += qty;
        }

        System.out.println("Maximum Stock = " + max);
        System.out.println("Minimum Stock = " + min);
        System.out.println("Total Stock = " + total);

        // Detect Duplicates
        System.out.print("Duplicate Quantities: ");
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int qty : stock) {
            if (!seen.add(qty)) {
                duplicates.add(qty);
            }
        }
        System.out.println(duplicates);

        // Rotate array by k positions
        int k = 2;
        rotateArray(stock, k);

        System.out.print("Array after rotation by " + k + ": ");
        for (int num : stock) {
            System.out.print(num + " ");
        }

        // 2D Shelf Grid
        int[][] shelf = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("\n\nOriginal Shelf Grid:");
        printMatrix(shelf);

        System.out.println("Transposed Shelf Grid:");
        transposeMatrix(shelf);
    }

    static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        printMatrix(transpose);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}