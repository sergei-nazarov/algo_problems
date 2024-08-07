package leetcode;

import java.util.*;

public class WordBreakII_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }

    public List<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> cache) {
        if (s.isEmpty()) {
            return List.of("");
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (dict.contains(word)) {
                for (String ss : dfs(s.substring(i), dict, cache)) {
                    String res = STR."\{word}\{ss.isEmpty() ? "" : " "}\{ss}";
                    result.add(res);
                }
            }
        }
        cache.put(s, result);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new WordBreakII_140().wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreakII_140().wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));


    }
}
