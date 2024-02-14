package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    public int romanToInt(String s) {

        Map<Character, Integer> letterToNumber = new HashMap<>();

        letterToNumber.put('I', 1);
        letterToNumber.put('V', 5);
        letterToNumber.put('X', 10);
        letterToNumber.put('L', 50);
        letterToNumber.put('C', 100);
        letterToNumber.put('D', 500);
        letterToNumber.put('M', 1000);

        char[] chars = s.toCharArray();
        int buffer = 0;
        int previous = 0;
        for (char aChar : chars) {
            int current = letterToNumber.get(aChar);
            if (current <= previous) {
                buffer += current;
            } else {
                buffer += current - 2 * previous;
            }
            previous = current;
        }
        return buffer;
    }

    public static void main(String[] args) {
        evoke("III", 3);
        evoke("IV", 4);
        evoke("LVIII", 58);
        evoke("MCMXCIV", 1994);
    }

    static void evoke(String x, int expected) {
        System.out.println(x + " : " + new RomanToInteger().romanToInt(x) + " : expected " + expected);
    }
}
