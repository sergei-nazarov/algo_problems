package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString_767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((x, y) -> count[y-'a'] - count[x-'a']);

        for (int i = 'a'; i <= 'z'; i++) {
            queue.offer((char) i);
        }

        StringBuilder sb = new StringBuilder();
        int c = queue.poll();
        while (count[c-'a'] != 0) {
            sb.append((char) c);
            count[c-'a']--;
            int prev = c;
            c = queue.poll();
            queue.offer((char) prev);
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString_767().reorganizeString("aab"));
        System.out.println(new ReorganizeString_767().reorganizeString("aaab"));

    }

}
