package leetcode;

import java.util.Arrays;
import java.util.Map;

public class LongestIdealSubsequence_2370 {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            int max = 0;
            for (int prev = 0; prev < 26; prev++) {
                if (Math.abs(c - 'a' - prev) <= k) {
                    max = Math.max(dp[prev], max);
                }
            }
            dp[c - 'a'] = max+1;
            System.out.println();
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new LongestIdealSubsequence_2370().longestIdealString("acfgbd", 2));
//        System.out.println(new LongestIdealSubsequence_2370().longestIdealString("pvjcci", 4));

    }
}
