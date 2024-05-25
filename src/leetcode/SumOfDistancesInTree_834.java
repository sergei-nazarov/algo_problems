package leetcode;

import java.util.*;

public class SumOfDistancesInTree_834 {
    List<List<Integer>> graph;
    int[] count;
    int[] res;
    int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        this.res = new int[N];
        this.count = new int[N];
        this.graph = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs1(int cur, int parent) {
        count[cur] = 1;
        for (int child : graph.get(cur)) {
            if (child != parent) {
                dfs1(child, cur);
                count[cur] += count[child];
                res[cur] += res[child] + count[child];
            }
        }
    }

    public void dfs2(int cur, int parent) {
        for (int child : graph.get(cur)) {
            if (child != parent) {
                res[child] = res[cur] + N - 2 * count[child];
                dfs2(child, cur);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumOfDistancesInTree_834().sumOfDistancesInTree(6, new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        })));
    }
}
