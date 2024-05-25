package leetcode;

public class CheckIfStraightLine_1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        if (point1[0] - point2[0] == 0) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != point1[0]) {
                    return false;
                }
            }
        } else {
            double k = (point1[1] - point2[1]) * 1.0 / (point1[0] - point2[0]);
            double b = point1[1] - k * point1[0];
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != k * coordinates[i][0] + b) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
//        System.out.println(new CheckIfStraightLine_1232().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
//        System.out.println(new CheckIfStraightLine_1232().checkStraightLine(new int[][]{{1, 2}, {6, 7}, {4, 5}, {5, 6}}));
//        System.out.println(new CheckIfStraightLine_1232().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 5}}));
//        System.out.println(new CheckIfStraightLine_1232().checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
        System.out.println(new CheckIfStraightLine_1232().checkStraightLine(new int[][]{{2, 1}, {4, 2}, {6, 3}}));

    }
}
