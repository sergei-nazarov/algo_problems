package leetcode;

import java.util.Arrays;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int shift = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                shift++;
            }else {
                nums[i-shift] = nums[i];
            }
        }
        return nums.length - shift;
    }

    public static void main(String[] args) {
        evoke(new int[]{3, 2, 2, 3}, 3);
        evoke(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);

    }

    static void evoke(int[] nums, int k) {
        System.out.println(Arrays.toString(nums) + " '" + k + "' : "
                + new RemoveElement_27().removeElement(nums, k) + " " + Arrays.toString(nums));
    }

}
