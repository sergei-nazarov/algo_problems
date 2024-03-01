package leetcode;

public class StringToInteger_8 {

    public int myAtoi(String s) {
        int result = 0;
        char[] chars = s.stripLeading().toCharArray();
        int max = (Integer.MAX_VALUE - 1) / 10;
        boolean inRange = true;
        boolean firstSymbolFounded = false;
        boolean isNegative = false;
        for (char symbol : chars) {
            if (!firstSymbolFounded && (symbol == '+' || symbol == '-')) {
                if (symbol == '-') {
                    isNegative = true;
                }
                firstSymbolFounded = true;
            } else if (isDigit(symbol)) {
                if (result < max) {
                    result = result * 10 + (symbol - '0');
                    firstSymbolFounded = true;
                } else if (result == max) {
                    if ((symbol - '0') <= 7) {
                        result = result * 10 + (symbol - '0');
                    } else {
                        inRange = false;
                        break;
                    }

                } else {
                    inRange = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (inRange) {
            return isNegative ? -result : result;
        }

        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    static boolean isDigit(char symbol) {
        return 48 <= symbol && symbol <= 57;
    }


    public static void main(String[] args) {
//        evoke("42");
//        evoke("   -42");
//        evoke("4193 with words");
//        evoke("words and 987");
//        evoke("  +   ");
//        evoke("  -  ");
        evoke("-91283472332");
        evoke("21474836460");
        evoke("2147483646");
        evoke("2147483648");
        evoke("-2147483647");
        evoke("2147483800");

    }

    static void evoke(String num) {
        System.out.println(num + " : "
                + new StringToInteger_8().myAtoi(num) + " ");
    }


}
