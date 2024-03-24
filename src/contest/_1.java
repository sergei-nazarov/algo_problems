package contest;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class _1 {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        int[] ints = new int[26];

        return inner(s, ints, 0, -1, 0);
    }

    public int inner(String s, int[] inner, int index, int firstOcc, int max) {
        if (index >= s.length()) return max;
        int c = s.charAt(index) - 'a';
        inner[c] = inner[c] + 1;
        if (inner[c] > 2) {
            int q = firstOcc;
            while (inner[c] > 2) {
                int c1 = s.charAt(q) - 'a';
                inner[c1] = inner[c1] - 1;
                max--;
                q++;
            }
            firstOcc = q;
        } else if (firstOcc == -1) {
            firstOcc = index;
        }
        max++;
        return Math.max(inner(s, inner, index + 1, firstOcc, max), max);
    }

    public static void main(String[] args) {
        System.out.println(new _1().maximumLengthSubstring("aaabbccdddaabbccddrr"));

        System.out.println(new _1().maximumLengthSubstring("aaabbaaa"));
        System.out.println(new _1().maximumLengthSubstring("bcbbbcba"));
        System.out.println(new _1().maximumLengthSubstring("aaaa"));

    }
}
