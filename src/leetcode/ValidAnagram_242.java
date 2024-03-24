package leetcode;

import java.util.HashMap;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];

        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram_242().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram_242().isAnagram("rat", "car"));
        System.out.println(new ValidAnagram_242().isAnagram("rat", "ca"));

    }
}
