package leetcode;

import java.util.Arrays;

public class ArithmeticProgression_1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3) return true;
        Arrays.sort(arr);
        int step = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != step) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ArithmeticProgression_1502().canMakeArithmeticProgression(new int[]{3, 1, 5}));
        System.out.println(new ArithmeticProgression_1502().canMakeArithmeticProgression(new int[]{3, 1, 7}));

    }
}
