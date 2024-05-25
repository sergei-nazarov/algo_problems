package leetcode;

import java.util.HashMap;

public class NumberOfWonderfulSubstrings_1915 {
    public long wonderfulSubstrings(String word) {

        char[] chars = word.toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long result = 0;
        int mask = 0;
        for (int i = 0; i < chars.length; i++) {
            int curr = chars[i] - 'a';
            mask = mask ^ (1 << curr);
            result += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
            for (int j = 0; j < 10; j++) {
                result += map.getOrDefault(mask ^ (1 << j), 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfWonderfulSubstrings_1915().wonderfulSubstrings("aba"));
        System.out.println(new NumberOfWonderfulSubstrings_1915().wonderfulSubstrings("aabb"));
        System.out.println(new NumberOfWonderfulSubstrings_1915().wonderfulSubstrings("he"));
    }
}
