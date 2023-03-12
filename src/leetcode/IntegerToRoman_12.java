package leetcode;

public class IntegerToRoman_12 {
    //IntegerToRoman_12    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int iteration = 0;
        while (num != 0) {
            int v = (num % 10) * (int) Math.pow(10, iteration);
            iteration++;
            num = num / 10;
            switch (v) {
                case 1 -> sb.append("I");
                case 2 -> sb.append("II");
                case 3 -> sb.append("III");
                case 4 -> sb.append("VI");
                case 5 -> sb.append("V");
                case 6 -> sb.append("IV");
                case 7 -> sb.append("IIV");
                case 8 -> sb.append("IIIV");
                case 9 -> sb.append("XI");
                case 10 -> sb.append("X");
                case 20 -> sb.append("XX");
                case 30 -> sb.append("XXX");
                case 40 -> sb.append("LX");
                case 50 -> sb.append("L");
                case 60 -> sb.append("XL");
                case 70 -> sb.append("XXL");
                case 80 -> sb.append("XXXL");
                case 90 -> sb.append("CX");
                case 100 -> sb.append("C");
                case 200 -> sb.append("CC");
                case 300 -> sb.append("CCC");
                case 400 -> sb.append("DC");
                case 500 -> sb.append("D");
                case 600 -> sb.append("CD");
                case 700 -> sb.append("CCD");
                case 800 -> sb.append("CCCD");
                case 900 -> sb.append("MC");
                case 1000 -> sb.append("M");
                case 2000 -> sb.append("MM");
                case 3000 -> sb.append("MMM");

            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        for (int i = 1; i < 3333; i++) {
            System.out.println(i + " -> " + new IntegerToRoman_12().intToRoman(i));

        }
    }
}
