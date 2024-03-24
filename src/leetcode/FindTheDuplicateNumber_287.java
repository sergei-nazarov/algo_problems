package leetcode;

public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length + 2];
        for (int num : nums) {
            int i = count[num];
            if (i == 0) {
                count[num] = 1;
            } else return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber_287().findDuplicate(new int[]{1, 2, 1}));
        System.out.println(new FindTheDuplicateNumber_287().findDuplicate(new int[]{5, 3, 2, 5}));

    }

}

