package leetcode;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        int[] iToZero = new int[matrix.length];
        int[] jToZero = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    iToZero[i] = 1;
                    jToZero[j] = 1;
                }
            }
        }

        for (int i = 0; i < iToZero.length; i++) {
            for (int j = 0; j < jToZero.length; j++) {
                if (iToZero[i] == 1 || jToZero[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        print(matrix);
        System.out.println();
        new SetMatrixZeroes().setZeroes(matrix2);
        print(matrix2);

    }

    static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(STR."\{anInt} ");
            }
            System.out.println(); // Переход на новую строку после печати строки матрицы
        }
    }
}
