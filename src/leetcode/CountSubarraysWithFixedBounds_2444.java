package leetcode;

public class CountSubarraysWithFixedBounds_2444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int l = 0;
        int secondMaxIndex = Integer.MIN_VALUE;
        int secondMinIndex = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                l = i + 1;
                secondMaxIndex = Integer.MIN_VALUE;
                secondMinIndex = Integer.MIN_VALUE;
                continue;
            }
            if (nums[i] == minK) {
                secondMinIndex = i;
            }
            if (nums[i] == maxK) {
                secondMaxIndex = i;
            }
            if (secondMaxIndex != Integer.MIN_VALUE && secondMinIndex != Integer.MIN_VALUE) {
                result += Math.min(secondMinIndex, secondMaxIndex) - l + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new CountSubarraysWithFixedBounds_2444().countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));//2
        System.out.println(new CountSubarraysWithFixedBounds_2444().countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));//10
        System.out.println(new CountSubarraysWithFixedBounds_2444().countSubarrays(new int[]{1, 2, 3, 1, 2, 1, 1}, 1, 2));//15


    }
}
