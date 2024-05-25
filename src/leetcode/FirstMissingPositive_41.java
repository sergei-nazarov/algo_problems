package leetcode;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int zeroCount = 0;

        for (int i = 0; i < len - zeroCount; i++) {
            if (zeroCount == len) return 1;
            if (nums[i] == i + 1) continue;
            if (nums[i] < 1 || nums[i] > nums.length || (nums[i] == nums[nums[i] - 1])) {
                nums[i] = nums[len - 1 - zeroCount];
                nums[len - 1 - zeroCount] = 0;
                zeroCount++;
                i--;
            } else if (nums[i] != i + 1) {
                int temp = nums[i];
                if (nums[temp - 1] < 1 || nums[temp - 1] > nums.length) {
                    nums[temp - 1] = temp;
                } else {
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                    i--;
                }
            }
        }
        int ans = 1;
        for (int num : nums) {
            if (num != ans) {
                return ans;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array3 = {1};
        int[] array4 = {1, 1};
        int[] array22 = {2, 2, 2};
        int[] array42 = {2, 1};
        int[] array45 = {1, 2, 0};
        int[] array0 = {2, 1, 3};
        int[] array1 = {7, 8, 9, 11, 12};
        int[] array2 = {5, 3, 1, 2, 6};
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array0) + " " + 4);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array1) + " " + 1);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array2) + " " + 4);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array3) + " " + 2);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array4) + " " + 2);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array45) + " " + 3);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array42) + " " + 3);
        System.out.println(new FirstMissingPositive_41().firstMissingPositive(array22) + " " + 1);


    }
}
