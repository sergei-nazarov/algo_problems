package leetcode;

import java.util.Arrays;

public class LargestPerimeterTriangle_976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = len - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LargestPerimeterTriangle_976().largestPerimeter(new int[]{1, 2, 2, 3, 10, 11, 12, 1}));
        System.out.println(new LargestPerimeterTriangle_976().largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(new LargestPerimeterTriangle_976().largestPerimeter(new int[]{1, 2, 1, 10}));

    }
}
