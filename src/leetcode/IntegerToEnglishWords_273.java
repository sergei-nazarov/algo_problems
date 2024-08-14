package leetcode;

public class IntegerToEnglishWords_273 {

    public String numberToWords(int num) {
        if (num == 0) return "zero";
        StringBuilder sb = new StringBuilder();
        String[] mega = {"", "Thousand", "Million", "Billion"};
        String[] mini = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] decimal = {"", "", "Twenty", "Thirty", "forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int idx = 0;
        while (num > 0) {
            String current = "";
            int rest = num % 1000;
            if (rest == 0) {
                num /= 1000;
                idx++;
                continue;
            }
            int hundreds = rest / 100;
            if (hundreds > 0) {
                current = STR."\{mini[hundreds]} Hundred ";
            }
            rest = rest % 100;
            if (rest >= 20) {
                current += STR."\{decimal[rest / 10]} " + (rest % 10 != 0 ? mini[rest % 10] + " " : "");
            } else if (rest > 0) {
                current += STR."\{mini[rest]} ";
            }
            current += idx != 0 ? STR."\{mega[idx]} " : "";
//            System.out.println(rest);
            num /= 1000;
            sb.insert(0, current);
            idx++;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
//        System.out.println(new IntegerToEnglishWords_273().numberToWords(123456));
//        System.out.println();
        System.out.println(new IntegerToEnglishWords_273().numberToWords(50868));
        System.out.println(new IntegerToEnglishWords_273().numberToWords(100000));


    }


}
