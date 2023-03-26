package leetcode;

import java.util.*;

public class _3Sum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int key = nums[i] + nums[right] + nums[left];
                if (key == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    right--;
                } else if (key < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        _3Sum_15 sum15 = new _3Sum_15();
        System.out.println(sum15.threeSum(new int[]{-1, 0, 1, 2, -1, 4}));
        System.out.println(sum15.threeSum(new int[]{0, 1, 1}));
        System.out.println(sum15.threeSum(new int[]{0, 0, 0}));
        System.out.println(sum15.threeSum(new int[]{1, 2, -2, -1}));

    }

}
