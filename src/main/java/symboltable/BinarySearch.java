package symboltable;

public class BinarySearch<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearch(int size) {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    public BinarySearch(Key[] keys, Value[] values) {
        this.keys = keys;
        this.values = values;
        n = keys.length;
    }

    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    public int rank(Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + ( (hi-lo)/2 );
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return values[i];
        return null;
    }

    public void addKey(Key key, Value value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if (n == keys.length) resize(2 * keys.length);

        for (int j = n ; j > i ; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key; values[i] = value;
        n++;
    }

    public void print () {
        for (int i = 0 ; i < keys.length ; i++ ) {
            System.out.println(keys[i] + "=" + values[i]);
        }
    }
}
