package unionfind;

public class QuickUnionLazy implements UF{

    private int[] id;

    public QuickUnionLazy(int N) {
        id = new int[N];
        for (int i = 0 ; i < N ; i++ ) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (id[i] != i) i = id[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        id[rootp] = id[rootq];
    }

    @Override
    public boolean connected(int p, int q) {
        return id[root(p)] == id[root(q)];
    }
}
