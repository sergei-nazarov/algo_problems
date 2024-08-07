package leetcode;

import java.util.*;

public class StudentAttendanceRecordII_552 {
    int modulo = (int) Math.pow(10, 9) + 7;
    int maxA = 2;
    int maxL = 3;

    int[][][] memo;

    public int checkRecord(int n) {
        memo = new int[n + 1][maxA][maxL];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return helper(n, 0, 0);
    }

    int helper(int n, int A, int L) {
        if (A >= maxA || L >= maxL) {
            return 0;
        }
        if (n == 0) return 1;
        if (memo[n][A][L] != -1) {
            return memo[n][A][L];
        }

        int result = helper(n - 1, A, 0) % modulo;
        result = (result + helper(n - 1, A + 1, 0) % modulo) % modulo;
        result = (result + helper(n - 1, A, L + 1) % modulo) % modulo;
        memo[n][A][L] = result;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecordII_552().checkRecord(10));
        System.out.println(new StudentAttendanceRecordII_552().checkRecord(10101));
        HashMap<String, Integer> map = new HashMap<>();
        List<String > list = List.of();
        list.sort(Comparator.comparing(map::get, Comparator.reverseOrder()));

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.<String, Integer>comparing(map::get, Comparator.reverseOrder()).thenComparing(Comparator.naturalOrder()));

    }
}
