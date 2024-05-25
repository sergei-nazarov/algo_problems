package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubarrayProductLessThanK_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int l = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            if (product < k) {
                result += i - l + 1;
            } else {
                while (product >= k && l <= i) {
                    product = product / nums[l++];
                }
                result += i - l + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new SubarrayProductLessThanK_713().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(new SubarrayProductLessThanK_713().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
}
