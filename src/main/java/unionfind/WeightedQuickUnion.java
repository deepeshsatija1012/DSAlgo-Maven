package unionfind;

public class WeightedQuickUnion implements UF {
    private int[] sz;
    private int[] id;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0 ; i < N ; i++ ) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]]; // this is path compression and only improves efficiency
            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = id[rootq];
            sz[rootq] += sz[rootp];
        } else {
            id[rootq] = id[rootp];
            sz[rootp] += sz[rootq];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[root(p)] == id[root(q)];
    }
}
