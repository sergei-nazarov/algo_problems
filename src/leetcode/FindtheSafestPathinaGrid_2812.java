package leetcode;

import java.util.*;

public class FindtheSafestPathinaGrid_2812 {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] gridArray = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int q = grid.get(i).get(j);
                if (q == 1) {
                    queue.add(new int[]{i, j});
                }
                gridArray[i][j] = -1;
            }
        }

        int dist = -1;
        int right = 0;

        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                if (i < 0 || j < 0 || i >= m || j >= n || gridArray[i][j] != -1) continue;
                gridArray[i][j] = dist;
                right = dist;
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i - 1, j});
                queue.add(new int[]{i, j + 1});
                queue.add(new int[]{i, j - 1});
            }
        }

        int left = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isPathExists(gridArray, mid, m, n)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return isPathExists(gridArray, right, m, n) ? right : left;
    }

    private boolean isPathExists(int[][] grid, int mid, int m, int n) {
        boolean[][] seen = new boolean[m][n];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] poll = deque.pollLast();
            int i = poll[0];
            int j = poll[1];
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] < mid || seen[i][j])
                continue;
            if (i == m - 1 && j == n - 1) return true;
            seen[i][j] = true;
            deque.add(new int[]{i + 1, j});
            deque.add(new int[]{i, j + 1});
            deque.add(new int[]{i - 1, j});
            deque.add(new int[]{i, j - 1});
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new FindtheSafestPathinaGrid_2812().maximumSafenessFactor(
//                new ArrayList<>() {{
//                    add(new ArrayList<>() {{
//                        add(0);
//                        add(1);
//                        add(1);
//                    }});
//                    add(new ArrayList<>() {{
//                        add(0);
//                        add(1);
//                        add(1);
//                    }});
//                    add(new ArrayList<>() {{
//                        add(0);
//                        add(0);
//                        add(1);
//                    }});
//
//                }}
//        ));

        System.out.println(new FindtheSafestPathinaGrid_2812().maximumSafenessFactor(
                new ArrayList<>() {{
                    add(new ArrayList<>() {{
                        add(0);
                        add(0);
                        add(0);
                        add(1);
                    }});
                    add(new ArrayList<>() {{
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                    }});
                    add(new ArrayList<>() {{
                        add(0);
                        add(0);
                        add(0);
                        add(0);
                    }});
                    add(new ArrayList<>() {{
                        add(1);
                        add(0);
                        add(0);
                        add(0);
                    }});


                }}
        ));
        System.out.println(new FindtheSafestPathinaGrid_2812().maximumSafenessFactor(
                new ArrayList<>() {{
                    add(new ArrayList<>() {{
                        add(1);
                    }});
                }}
        ));

    }
}
