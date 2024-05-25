package leetcode;

public class PerfectSquares_279 {
    public int numSquares(int n) {
        if (n == 0) return 0;
        int pow = (int) Math.sqrt(n);

        int result = Integer.MAX_VALUE;
        for (int i = pow; i > pow - 4 && i > 0; i--) {
            int p = i * i;
            int ans = numSquares(n % (p)) + n / p;
            result = Math.min(ans, result);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new PerfectSquares_279().numSquares(12));
        System.out.println(new PerfectSquares_279().numSquares(88));

    }
}
