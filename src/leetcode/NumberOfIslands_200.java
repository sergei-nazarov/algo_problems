package leetcode;

import java.util.Arrays;

public class NumberOfIslands_200 {
    int[] parent;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        Arrays.fill(parent, -1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (var dir : dirs) {
                        int y = i + dir[0];
                        int x = j + dir[1];
                        if (y >= 0 && y < m && x >= 0 && x < n && grid[y][x] == '1') {
                            union(i * n + j, y * n + x);
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m * n; i++) {
            if (parent[i] == i)
                result++;
        }
        return result;
    }

    int find(int x) {
        if (parent[x] == -1)
            return -1;
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (parX == -1 && parY == -1) {
            parent[x] = y;
            parent[y] = y;
        } else if (parX != -1 && parY != -1) {
            parent[parX] = parY;
        } else if (parY != -1) {
            parent[x] = parY;
        } else {
            parent[y] = parX;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands_200().numIslands(new char[][]{{'1'}, {'1'}}));
    }
}
