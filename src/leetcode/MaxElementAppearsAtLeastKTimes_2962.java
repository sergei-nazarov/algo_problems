package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxElementAppearsAtLeastKTimes_2962 {
    public long countSubarrays(int[] nums, int k) {
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        long kKount = 0;
        int left = 0;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                kKount++;
            }
            if (kKount == k) {
                while (kKount == k) {
                    if (nums[left++] == max) {
                        kKount--;
                    }
                }
            }
                result += left;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new MaxElementAppearsAtLeastKTimes_2962().countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
//        System.out.println(new MaxElementAppearsAtLeastKTimes_2962().countSubarrays(new int[]{1, 4, 2, 1}, 3));
        System.out.println(new MaxElementAppearsAtLeastKTimes_2962().countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));

    }
}
