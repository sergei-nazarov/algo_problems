package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination_17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return List.of();
        Map<Character, List<String>> letters = new HashMap<>();
        letters.put('2', List.of("a", "b", "c"));
        letters.put('3', List.of("d", "e", "f"));
        letters.put('4', List.of("g", "h", "i"));
        letters.put('5', List.of("j", "k", "l"));
        letters.put('6', List.of("m", "n", "o"));
        letters.put('7', List.of("p", "q", "r", "s"));
        letters.put('8', List.of("t", "u", "v"));
        letters.put('9', List.of("w", "x", "y", "z"));

        List<String> result = letters.get(digits.charAt(0));

        for (int i = 1; i < digits.length(); i++) {
            result = makeCombos(result, letters.get(digits.charAt(i)));
        }

        return result;
    }

    private List<String> makeCombos(List<String> current, List<String> next) {
        List<String> result = new ArrayList<>();
        for (String s : current) {
            for (String value : next) {
                result.add(s + value);
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        evoke("5");
        evoke("23");
        evoke("333");
    }

    static void evoke(String nums) {
        System.out.println(nums + " : "
                + new LetterCombination_17().letterCombinations(nums));
    }


}
