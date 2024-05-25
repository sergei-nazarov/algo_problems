package leetcode;

public class MinimumLevelsToGainMorePoints_3096 {

    public int minimumLevels(int[] possible) {
        int endValue = 0;
        for (int j : possible) {
            endValue += j == 1 ? 1 : -1;
        }
        int a = 0;
        int b = endValue;
        for (int i = 0; i < possible.length - 1; i++) {
            a += possible[i] == 1 ? 1 : -1;
            b -= possible[i] == 1 ? 1 : -1;
            if (a > b) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 0, 1, 0}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{0, 0}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 0}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{0, 0, 0}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{0, 0, 1, 0}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{0, 0, 0, 1}));
        System.out.println(new MinimumLevelsToGainMorePoints_3096().minimumLevels(new int[]{1, 0, 1}));


    }
}
