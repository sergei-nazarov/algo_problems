package leetcode;

import java.util.Arrays;
import java.util.Map;

public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        char[] chars = new char[word1Length + word2Length];
        int min = Math.min(word1Length, word2Length);
        for (int i = 0; i < min; i++) {
            chars[i * 2] = word1.charAt(i);
            chars[i * 2 + 1] = word2.charAt(i);
        }
        if (word1Length > word2Length) {
            for (int i = min; i < word1Length; i++) {
                chars[min + i] = word1.charAt(i);
            }
        } else if (word1Length < word2Length) {
            for (int i = min; i < word2Length; i++) {
                chars[min + i] = word2.charAt(i);
            }

        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        evoke("abc", "pqr");
        evoke("ab", "pqrs");
        evoke("pqrs", "ab");
    }

    static void evoke(String first, String second) {
        System.out.println(first + " " + second + " : "
                + new MergeStringsAlternately_1768().mergeAlternately(first, second));
    }


}
