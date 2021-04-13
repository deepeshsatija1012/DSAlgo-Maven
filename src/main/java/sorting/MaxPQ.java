package sorting;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;

    public MaxPQ(int capacity) {
        keys = (Key[]) new Comparable[capacity + 1];
    }

    public MaxPQ(Key[] a) {

    }

    public void insert(Key key) {
        keys[++N] = key;
        SortingUtils.swim(keys, N);
    }

    private void exch(Key[] arr, int i, int j) {
        Key t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void exch(int i, int j) {
        Key t = keys[i];
        keys[i] = keys[j];
        keys[j] = t;
    }

    public Key delMax() {
        Key max = keys[1];
        exch(1, N--);
        SortingUtils.sink(keys, N, 1);
        keys[N+1] = null;
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key max() {
        return keys[1];
    }

    public int size() {
        return N;
    }
}
