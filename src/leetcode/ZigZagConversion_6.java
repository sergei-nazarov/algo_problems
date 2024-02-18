package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            rows.get(findRow(numRows, i)).append(s.charAt(i));
        }
        StringBuilder resultString = new StringBuilder();
        rows.forEach(resultString::append);

        return resultString.toString();
    }

    public int findRow(int numRows, int number) {
        int nextPeek = numRows * 2 - 2;
        int relative = number % nextPeek;
        int result;
        if (relative < numRows) {
            result = relative;
        } else {
            result = (2 * (numRows - 1)) - relative;
        }
        return result;
    }

    //3 - 0 4 8 12
    //4 - 0 6 12
    public static void main(String[] args) {
//    PAHNAPLSIIGYIR
        System.out.println(new ZigZagConversion_6().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZagConversion_6().convert("PAYPALISHIRING", 4));
        System.out.println(new ZigZagConversion_6().convert("PAYPALISHIRING", 5));

        System.out.println(new ZigZagConversion_6().convert("AB", 1));


    }
}
