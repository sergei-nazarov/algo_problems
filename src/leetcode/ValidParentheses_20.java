package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Map<Character, Character> par = new HashMap<>();
        par.put('(', ')');
        par.put('[', ']');
        par.put('{', '}');
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (stack.size()==0 || par.get(stack.pop()) != current) {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        evoke("()", true);
        evoke("()[]{}", true);
        evoke("(]", false);
        evoke("{[]}", true);
    }

    static void evoke(String x, boolean expected) {
        System.out.println(x + " : "
                + new ValidParentheses_20().isValid(x) + " : expected " + expected);
    }

}
