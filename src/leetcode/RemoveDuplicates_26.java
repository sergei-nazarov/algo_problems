package leetcode;

import java.util.Arrays;

public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        int shift = 0;
        int prev = nums[0];
        int unique = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == prev){
                shift++;
            }else {
                unique++;
                prev = nums[i];
                nums[i-shift] = nums[i];
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        evoke(new int[]{1,1,2});
        evoke(new int[]{0,0,1,1,1,2,2,3,3,4});

    }

    static void evoke(int[] nums) {
        System.out.println(Arrays.toString(nums) + " : "
                + new RemoveDuplicates_26().removeDuplicates(nums) + " " + Arrays.toString(nums));
    }

}
