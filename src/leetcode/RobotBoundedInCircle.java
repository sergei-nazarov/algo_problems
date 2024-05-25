package leetcode;

import java.util.Arrays;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[] cord = new int[2];
        int dir = 0;
        char[] charArray = instructions.toCharArray();
        for (char c : charArray) {
            if (c == 'G') {
                if (dir == 0) {
                    cord[1]++;
                } else if (dir == 1) {
                    cord[0]++;
                } else if (dir == 2) {
                    cord[1]--;
                } else {
                    cord[0]--;
                }
            } else if (c == 'R') {
                dir++;
                if (dir == 4) {
                    dir = 0;
                }
            } else {
                dir--;
                if (dir == -1) {
                    dir = 3;
                }
            }
        }
        return (cord[0] == 0 && cord[1] == 0) || dir != 0;
    }

    public static void main(String[] args) {
        System.out.println(new RobotBoundedInCircle().isRobotBounded("GGLLGG"));
        System.out.println(new RobotBoundedInCircle().isRobotBounded("GG"));
        System.out.println(new RobotBoundedInCircle().isRobotBounded("GL"));


    }
}
