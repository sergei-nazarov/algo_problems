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
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        boolean isDown = false;
        int realNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(realNumber).add(s.charAt(i));
            if (realNumber == 0 || realNumber == numRows - 1) {
                isDown = !isDown;
            }
            realNumber = isDown ? realNumber + 1 : realNumber - 1;
        }
        return rows.stream().flatMap(Collection::stream).map(Object::toString).collect(Collectors.joining());
    }

    //3 - 0 4 8 12
    //4 - 0 6 12
    public static void main(String[] args) {
//    PAHNAPLSIIGYIR
        System.out.println(new ZigZagConversion_6().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZagConversion_6().convert("AB", 1));

    }
}
