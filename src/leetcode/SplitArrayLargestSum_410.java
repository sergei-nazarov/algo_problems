package leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int num : nums) {
            end += num;
            start = Math.max(start, num);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int parts = parts(nums, mid);
            if (parts <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    int parts(int[] nums, int maxVal) {
        long sum = 0;
        int parts = 1;
        for (int num : nums) {
            if (sum + num <= maxVal) {
                sum += num;
            } else {
                sum = num;
                parts++;
            }
        }
        return parts;
    }

    public static void main(String[] args) {
//        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{9, 1, 2, 2, 3}, 2));//9
//        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{19, 1, 2, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 2));//19
        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{7, 2, 5, 10, 8}, 2));//18
        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{1, 2, 3, 4, 5}, 2));//9
        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{1, 2, 3, 4, 5}, 3));//6
        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{1, 2, 3, 4, 5}, 5));//5
        System.out.println(new SplitArrayLargestSum_410().splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5));//5

    }
}
