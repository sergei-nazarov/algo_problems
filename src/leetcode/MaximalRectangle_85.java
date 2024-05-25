package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;

        for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (matrix[rowIdx][i] == '1') ? heights[i] + 1 : 0;
            }

            System.out.println("After row " + (rowIdx + 1) + " processing, heights: ");
            for (int h : heights) {
                System.out.print(h + " ");
            }
            System.out.println();

            // Calculate max area using stack-based method
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                    System.out.println("Calculate area: height=" + h + ", width=" + w + ", area=" + (h * w));
                }
                stack.push(i);
                System.out.println("Push index to stack: " + i + ", current stack: " + stack);
            }
            System.out.println("Max area so far: " + maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaximalRectangle_85 sol = new MaximalRectangle_85();
        int maxArea = sol.maximalRectangle(matrix);
        System.out.println("Final maximum area: " + maxArea);
    }
}
