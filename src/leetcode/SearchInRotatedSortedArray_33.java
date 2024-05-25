package leetcode;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int current = nums[mid];
            if (current == target) {
                return mid;
            } else if (nums[left] <= current) {
                if (nums[left] <= target && target <= current) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (current <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{1, 3}, 3));//1
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));//1
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{6, 7, 0, 1, 2, 4, 5,}, 1));//3
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{6, 7, 0, 1, 2, 4, 5,}, 4));//5
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));//5
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));//4
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 4}, 4));//6
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));//-1
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{1}, 0));//-1
        System.out.println(new SearchInRotatedSortedArray_33().search(new int[]{5,1,3}, 3));//-1

    }

}
