package contest;

import java.util.ArrayList;
import java.util.List;

public class _2 {
    public int minOperations(int k) {
        if (k == 1) return 0;
        if (k == 2) return 1;
        if (k == 3) return 2;
        int min = Integer.MAX_VALUE;
        for (int i = 2; i < k / 2 + 1; i++) {
            int countMult = (k % i > 0 ? k / i + 1 : k / i) - 1;
            min = Math.min(min, i + countMult);
        }
        return min - 1;
    }

    public static void main(String[] args) {
        System.out.println(new _2().minOperations(1));
        System.out.println(new _2().minOperations(2));
        System.out.println(new _2().minOperations(3));
        System.out.println(new _2().minOperations(4));
        System.out.println(new _2().minOperations(5));
        System.out.println(new _2().minOperations(11));
        System.out.println(new _2().minOperations(12));
        System.out.println(new _2().minOperations(13));
    }
}
