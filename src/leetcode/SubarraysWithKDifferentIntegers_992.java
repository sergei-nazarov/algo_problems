package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atLeastK(nums, k) - atLeastK(nums, k - 1);
    }

    private static int atLeastK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            map.merge(current, 1, Integer::sum);
            while (map.size() > k) {
                int leftVal = nums[left++];
                Integer num = map.get(leftVal);
                if (num == 1) {
                    map.remove(leftVal);
                } else {
                    map.put(leftVal, num - 1);
                }
            }
            result += i - left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraysWithKDifferentIntegers_992().subarraysWithKDistinct(new int[]{1, 4, 2, 2, 1, 1, 3}, 2));
        System.out.println(new SubarraysWithKDifferentIntegers_992().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(new SubarraysWithKDifferentIntegers_992().subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }
}
