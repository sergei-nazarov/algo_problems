package leetcode;

import java.util.Arrays;

public class SpiralMatrixIII_885 {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int size = rows * cols;

        int pos = 0;
        int[][] result = new int[size][2];

        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int dir = 0;
        int length = 1;
        int madeSteps = 0;
        while (pos < size) {
            if (rStart >= 0 && cStart >= 0 && rStart < rows && cStart < cols) {
                result[pos++] = new int[]{rStart, cStart};
            }
            rStart += dirs[dir][0];
            cStart += dirs[dir][1];
            madeSteps++;
            System.out.println(rStart + " " + cStart);
            if (madeSteps == length) {
                dir = (dir + 1) % 4;
                if (dir == 0 || dir == 2) {
                    length++;
                }
                madeSteps = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrixIII_885().spiralMatrixIII(1, 4, 0, 0)));
    }
}
