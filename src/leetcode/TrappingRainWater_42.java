package leetcode;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int pool = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                pool += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                pool += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return pool;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater_42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrappingRainWater_42().trap(new int[]{4, 2, 0, 3, 2, 5}));

    }
}
