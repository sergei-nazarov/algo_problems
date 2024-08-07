package graph;

public class UnionFind {
    private final int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
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
