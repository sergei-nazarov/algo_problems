package leetcode;

import java.util.Arrays;

public class _3sumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int key = nums[i] + nums[right] + nums[left];
                if (Math.abs(target - result) > Math.abs(target - (nums[i] + nums[left] + nums[right])))
                    result = nums[i] + nums[left] + nums[right];
                if (key < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _3sumClosest_16 sum15 = new _3sumClosest_16();
        System.out.println(sum15.threeSumClosest(new int[]{-1, 2, 1, -4}, 2));
        System.out.println(sum15.threeSumClosest(new int[]{0, 0, 0, 0}, 1));

    }
}
