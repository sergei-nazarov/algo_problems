package leetcode;

import java.util.Arrays;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{9, 9, 9})));


    }
}
