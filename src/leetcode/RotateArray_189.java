package leetcode;

import java.util.Arrays;

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        int shift = 1;
        int i = 0;
        int swaps = 0;
        while (swaps++ < nums.length) {
            int sm = (i + shift * k) % nums.length;
            int temp = nums[sm];
            nums[sm] = nums[i];
            nums[i] = temp;
            shift++;
            if (i == sm) {
                i++;
                shift = 1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
//        new RotateArray_189().rotate(new int[]{1, 2, 3}, 1);
//        new RotateArray_189().rotate(new int[]{1, 2, 3}, 2);
//        new RotateArray_189().rotate(new int[]{1, 2, 3}, 3);
//        new RotateArray_189().rotate(new int[]{1, 2, 3}, 6);
//        new RotateArray_189().rotate(new int[]{1, 2, 3}, 4);
        new RotateArray_189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7,}, 3);
        new RotateArray_189().rotate(new int[]{-1, -100, 3, 99}, 2);

//                new RotateArray_189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7,}, 3);

    }
}
