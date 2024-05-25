package leetcode;

import java.util.Arrays;

public class DiagonalTraverse_498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int N = mat.length, M = mat[0].length;
        int[] result = new int[N * M];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < N * M; i++) {
            result[i] = mat[row][col];
            row -= d;
            col += d;
            if (row >= N) { row = N - 1; col += 2; d = -d; } // Вышли за нижнюю границу
            if (col >= M) { col = M - 1; row += 2; d = -d; } // Вышли за правую границу
            if (row < 0)  { row = 0; d = -d; }               // Вышли за верхнюю границу
            if (col < 0)  { col = 0; d = -d; }               // Вышли за левую границу
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiagonalTraverse_498().findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
        System.out.println(Arrays.toString(new DiagonalTraverse_498().findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        })));

    }
}
