package leetcode;

import java.util.*;

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        int num = 0;
        List<Integer> list = List.of(2,3,5);
        queue.offer(1L);
        while (num<n-1){
            long i = queue.poll();
            for(int nu : list){
                long q = i * nu;
                if(!seen.contains(q)){
                    queue.offer(q);
                    seen.add(q);
                }
            }
            num++;
        }
        return Math.toIntExact(queue.poll());
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII_264().nthUglyNumber(10));
    }

}
