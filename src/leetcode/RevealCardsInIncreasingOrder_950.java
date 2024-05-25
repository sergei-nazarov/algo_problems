package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        for (int num : deck) {
            Integer nextIndex = queue.poll();
            result[nextIndex] = num;
            queue.offer(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RevealCardsInIncreasingOrder_950().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

}
