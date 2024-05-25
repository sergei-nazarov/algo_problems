package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        return helper(s, 0, new ArrayList<>());
    }

    List<List<String>> helper(String s, int start, List<String> list) {
        int len = s.length();
        List<List<String>> result = new ArrayList<>();
        if (start >= len) {
            result.add(list);
            return result;
        }

        for (int i = start; i < len; i++) {

            int left = 0;
            int right = 0;
            while (i - left >= start && i + right < len && s.charAt(i - left) == s.charAt(i + right)) {
                left++;
                right++;
            }
            if (i - left + 1 == start && right <= len) {
                List<String> newList = new ArrayList<>(list);
                newList.add(s.substring(start, i + right ));
                result.addAll(helper(s, i + right, newList));
            }

            left = 0;
            right = 1;
            while (i - left >= start && i + right < len && s.charAt(i - left) == s.charAt(i + right)) {
                left++;
                right++;
            }
            if (i - left + 1 == start && right < len) {
                List<String> newList = new ArrayList<>(list);
                newList.add(s.substring(start, i + right ));
                result.addAll(helper(s, i + right, newList));
            }

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning_131().partition("a"));
    }

}
