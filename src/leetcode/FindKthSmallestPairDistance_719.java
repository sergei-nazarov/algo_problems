package leetcode;

import java.util.*;

public class FindKthSmallestPairDistance_719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int res = lessThanMid(nums, mid);
            if (res < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }
        return min;
    }

    private int lessThanMid(int[] nums, int mid) {
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            result += right - left;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthSmallestPairDistance_719().smallestDistancePair(new int[]{1, 3, 1}, 1));//0
        System.out.println(new FindKthSmallestPairDistance_719().smallestDistancePair(new int[]{1, 1, 1}, 2));//0
        System.out.println(new FindKthSmallestPairDistance_719().smallestDistancePair(new int[]{1, 6, 1}, 3));//5
        System.out.println(new FindKthSmallestPairDistance_719().smallestDistancePair(new int[]{1, 2, 5, 9, 14, 20, 21}, 2));//5
    }
}
