package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength_2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            map.merge(current, 1, Integer::sum);
            while (map.get(current) > k) {
                map.computeIfPresent(nums[left++], (_, v) -> v - 1);
            }
            result = Math.max(result, i - left + 1);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new MaxSubarrayLength_2958().maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }

}
