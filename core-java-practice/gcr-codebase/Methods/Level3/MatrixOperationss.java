package Level3;
import java.util.*;

public class MatrixOperationss {
    static int[][] createMatrix(int r, int c) {
        Random rand = new Random();
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = rand.nextInt(10);
            }
        }
        return m;
    }

    static int[][] transpose(int[][] m) {
        int r = m.length, c = m[0].length;
        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }

    static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double)det;
        inv[0][1] = -m[0][1] / (double)det;
        inv[1][0] = -m[1][0] / (double)det;
        inv[1][1] = m[0][0] / (double)det;
        return inv;
    }

    static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[][] minor = new int[2][2];
                int mi = 0, mj;
                for (int r = 0; r < 3; r++) {
                    if (r == i) continue;
                    mj = 0;
                    for (int c = 0; c < 3; c++) {
                        if (c == j) continue;
                        minor[mi][mj] = m[r][c];
                        mj++;
                    }
                    mi++;
                }
                int cof = determinant2x2(minor);
                inv[j][i] = Math.pow(-1, i + j) * cof / (double)det;
            }
        }
        return inv;
    }

    static void display(int[][] m) {
        for (int[] row : m) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    static void display(double[][] m) {
        for (double[] row : m) {
            for (double val : row) System.out.printf("%.2f ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m2 = createMatrix(2, 2);
        int[][] m3 = createMatrix(3, 3);
        display(m2);
        System.out.println("Det 2x2: " + determinant2x2(m2));
        double[][] inv2 = inverse2x2(m2);
        if (inv2 != null) display(inv2);
        display(m3);
        System.out.println("Det 3x3: " + determinant3x3(m3));
        double[][] inv3 = inverse3x3(m3);
        if (inv3 != null) display(inv3);
        display(transpose(m3));
    }
}