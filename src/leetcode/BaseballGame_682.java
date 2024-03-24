package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BaseballGame_682 {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    int val3 = val1 + val2;
                    stack.push(val2);
                    stack.push(val1);
                    stack.push(val3);
                    sum += val3;
                }
                case "D" -> {
                    int peek = stack.peek() * 2;
                    stack.push(peek);
                    sum += peek;
                }
                case "C" -> sum -= stack.pop();
                default -> {
                    int val = Integer.parseInt(operation);
                    stack.push(val);
                    sum += val;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new BaseballGame_682().calPoints(new String[]{"5", "2", "C", "D", "+"}) + " expected " + 30);
        System.out.println(new BaseballGame_682().calPoints(new String[]{"1", "C"}) + " expected " + 0);

    }
}
