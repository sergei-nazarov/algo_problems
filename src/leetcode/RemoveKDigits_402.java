package leetcode;

public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        for (int j = 1; j < num.length(); j++) {
            if (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > num.charAt(j)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
                j--;
            } else
                sb.append(num.charAt(j));
        }
        while (k > 0 && !sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }


        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits_402().removeKdigits("1999219", 3));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("91919219", 3));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("1432219", 3));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("10200", 1));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("10", 1));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("10001", 4));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("12345", 2));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("1234567890", 9));//1219
        System.out.println(new RemoveKDigits_402().removeKdigits("000000000000000", 9));//1219


    }
}
