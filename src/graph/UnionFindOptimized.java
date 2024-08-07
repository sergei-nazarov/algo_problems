package graph;

public class UnionFindOptimized {
    private final int[] parent;
    private final int[] rank;

    public UnionFindOptimized(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        if (p != parent[p]) {
            parent[p] = find(parent[p]); // Path compression
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }

    public static void main(String[] args) {
        UnionFindOptimized uf = new UnionFindOptimized(10);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(5, 6);
        uf.union(7, 8);
        uf.union(2, 8);
        System.out.println(uf.find(1)); // Output will be the root of 1's set
        System.out.println(uf.find(2)); // Output will be the root of 2's set
        System.out.println(uf.find(7)); // Output will be the root of 7's set
        System.out.println(uf.find(8)); // Output will be the root of 8's set
    }
}
