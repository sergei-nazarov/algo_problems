package leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String commonPref = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPref = commonPref(commonPref, strs[i]);
        }
        return commonPref;
    }

    String commonPref(String string1, String string2) {
        int len = Math.min(string1.length(), string2.length());
        int i;
        for (i = 0; i < len; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                break;
            }
        }
        return string1.substring(0, i);
    }

    public static void main(String[] args) {
        evoke(new String[]{"flower", "flow", "flight"}, "fl");
        evoke(new String[]{"dog", "racecar", "car"}, "");
    }

    static void evoke(String[] x, String expected) {
        System.out.println(Arrays.toString(x) + " : "
                + new LongestCommonPrefix_14().longestCommonPrefix(x) + " : expected " + expected);
    }
}
