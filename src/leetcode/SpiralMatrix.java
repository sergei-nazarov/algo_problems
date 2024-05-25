package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0, y = 0;
        int xSize = matrix[0].length;
        int ySize = matrix.length;
        int xDir = 1;
        int yDir = 0;
        int circle = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (result.size() < xSize * ySize) {
            result.add(matrix[y][x]);
            if (x + xDir == xSize - circle && xDir == 1) {
                xDir = 0;
                yDir = 1;
            } else if (x + xDir == circle - 1 && xDir == -1) {
                xDir = 0;
                yDir = -1;
                circle++;
            } else if (y + yDir == ySize - circle && yDir == 1) {
                xDir = -1;
                yDir = 0;
            } else if (y + yDir == circle - 1 && yDir == -1) {
                xDir = 1;
                yDir = 0;
            }
            x += xDir;
            y += yDir;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
        System.out.println(new SpiralMatrix().spiralOrder(matrix2));

    }
}
