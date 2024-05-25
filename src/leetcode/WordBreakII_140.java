package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        ArrayList<String> result = new ArrayList<>();
        helper(s, dict, 0, result, new StringBuilder());
        return result;
    }

    public void helper(String s, Set<String> dict, int pos, List<String> result, StringBuilder sb) {
        if (s.length() == pos) {
            result.add(sb.deleteCharAt(sb.length() - 1).toString());
            sb.append(" ");
            return;
        }
        StringBuilder currentWord = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            currentWord.append(s.charAt(i));
            if (dict.contains(currentWord.toString())) {
                sb.append(currentWord).append(" ");
                helper(s, dict, i + 1, result, sb);
                sb.delete(sb.length() - currentWord.length() - 1, sb.length());
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new WordBreakII_140().wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreakII_140().wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple")));


    }
}
