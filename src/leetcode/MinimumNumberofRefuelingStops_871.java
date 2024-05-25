package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops_871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int maxDist = startFuel;
        int stops = 0;
        int i = 0;
        while (maxDist < target) {
            while (i < stations.length && stations[i][0] <= maxDist) {
                pq.offer(stations[i][0]);
                i++;
            }

            if (pq.isEmpty()) return -1;
            maxDist += pq.poll();
            stops++;
        }
        return stops;
    }

    public static void main(String[] args) {
//        System.out.println(new MinimumNumberofRefuelingStops_871()
//                .minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
//        System.out.println(new MinimumNumberofRefuelingStops_871()
//                .minRefuelStops(100, 1, new int[][]{{10, 100}}));
//        System.out.println(new MinimumNumberofRefuelingStops_871()
//                .minRefuelStops(100, 50, new int[][]{{25, 30}}));
        System.out.println(new MinimumNumberofRefuelingStops_871()
                .minRefuelStops(100, 1, new int[][]{}));


    }
}
