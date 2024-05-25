package leetcode;

import java.util.Arrays;

public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        char[] ch1 = sb1.reverse().toString().toCharArray();
        char[] ch2 = sb2.reverse().toString().toCharArray();

        int[] result = new int[ch1.length + ch2.length];
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                int product = (ch1[i] - '0') * (ch2[j] - '0');
                result[i + j] += product;
            }
        }

        for (int i = 0; i < result.length; i++) {
            int currentNum = result[i];
            if (currentNum > 9) {
                result[i] = currentNum % 10;
                result[i + 1] += currentNum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i);
        }
        int sbLen = sb.length();
        while (sb.charAt(sbLen - 1) == '0' && sbLen != 1) {
            sb.deleteCharAt(sbLen-- - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings_43().multiply("99", "9") + " " + 891);
        System.out.println(new MultiplyStrings_43().multiply("9", "99") + " " + 891);
        System.out.println(new MultiplyStrings_43().multiply("123", "456") + " " + 56088);
        System.out.println(new MultiplyStrings_43().multiply("999", "999") + " " + 998001);
        System.out.println(new MultiplyStrings_43().multiply("999", "0") + " " + 0);


    }


}
