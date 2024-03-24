package leetcode;

import java.util.Arrays;

public class MoveZeros_283 {

    public void moveZeroes(int[] nums) {
        int zeroCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
            } else {
                nums[i - zeroCounter] = nums[i];
            }
        }
        for (int i = nums.length - zeroCounter; i < nums.length; i++) {
            nums[i] = 0;

        }
    }


    public static void main(String[] args) {
        int[] ints11 = {4, 5, 0, 3, 12};
        new MoveZeros_283().moveZeroes(ints11);
        System.out.println(Arrays.toString(ints11));

        int[] ints = {0, 0, 0, 3, 12};
        new MoveZeros_283().moveZeroes(ints);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = {0, 2, 0, 3, 12};
        new MoveZeros_283().moveZeroes(ints2);
        System.out.println(Arrays.toString(ints2));

    }

}
