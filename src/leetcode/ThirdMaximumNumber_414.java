package leetcode;

import java.util.Arrays;

public class ThirdMaximumNumber_414 {
    public int thirdMax(int[] nums) {
        long[] maxes = new long[3];
        Arrays.fill(maxes, Long.MIN_VALUE);
        for (int num : nums) {
            if (num > maxes[2]) {
                maxes[0] = maxes[1];
                maxes[1] = maxes[2];
                maxes[2] = num;
            } else if (num > maxes[1] && num != maxes[2]) {
                maxes[0] = maxes[1];
                maxes[1] = num;
            } else if (num > maxes[0] && num != maxes[1] && num != maxes[2]) {
                maxes[0] = num;
            }
        }
        return (int) (maxes[0] == Long.MIN_VALUE ? maxes[2] : maxes[0]);
    }

    public static void main(String[] args) {
        ThirdMaximumNumber_414 thirdMaximumNumber414 = new ThirdMaximumNumber_414();
//        System.out.println(thirdMaximumNumber414.thirdMax(new int[]{1, 2, 3, 4}));
        System.out.println(thirdMaximumNumber414.thirdMax(new int[]{4, 1, 2, 3, 4, 1, 1, 4}));
        System.out.println(thirdMaximumNumber414.thirdMax(new int[]{1, 2}));
        System.out.println(thirdMaximumNumber414.thirdMax(new int[]{2, 3, 1}));
        System.out.println(thirdMaximumNumber414.thirdMax(new int[]{2, 1, 1, 1, 1, 1, 1}));


    }
}
