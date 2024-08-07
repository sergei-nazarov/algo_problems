package leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        var deque = new ArrayDeque<Integer>();
        int maxArea = 0;

        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            if (deque.isEmpty() || h >= heights[deque.peek()]) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && heights[deque.peek()] >= h) {
                    int pop = deque.pop();
                    int left = deque.isEmpty() ? 0 : deque.peek() + 1;
                    maxArea = Math.max(maxArea, heights[pop] * (i - left));
                }
                deque.push(i);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram_84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LargestRectangleInHistogram_84().largestRectangleArea(new int[]{1, 1}));
        System.out.println(new LargestRectangleInHistogram_84().largestRectangleArea(new int[]{2, 1, 2}));


    }
}
