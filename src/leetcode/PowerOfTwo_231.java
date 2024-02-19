package leetcode;

import java.util.Arrays;

public class PowerOfTwo_231 {

    public boolean isPowerOfTwo(int n) {

//        return n > 0 && Integer.numberOfTrailingZeros(n) + Integer.numberOfLeadingZeros(n) == 31;
        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        evoke(0);
        evoke(1);
        evoke(2);
        evoke(3);
        evoke(4);
        evoke(5);
        evoke(32);
        evoke(33);


    }

    static void evoke(int num) {
        System.out.println(num + " : "
                + new PowerOfTwo_231().isPowerOfTwo(num) + " ");
    }

}
