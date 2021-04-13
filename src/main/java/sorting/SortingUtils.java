package sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortingUtils {

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void bubbleSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a, j, j - 1)) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void selectionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a, j, min)) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void insertionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a, j, j - 1)) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void shellSort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a, j, j - h)) {
                        exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }

    private static void mergeWithCopy(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux, j, i)) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void mergeSortWithCopy(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + ((hi - lo) / 2);
        mergeSortWithCopy(a, aux, lo, mid);
        mergeSortWithCopy(a, aux, mid + 1, hi);
        mergeWithCopy(a, aux, lo, mid, hi);
    }

    public static void mergeSortWithCopy(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSortWithCopy(a, aux, 0, a.length - 1);
    }

    private static void mergeWithoutCopy(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else if (less(a, j, i)) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
    }

    private static void mergeSortWithoutCopy(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + ((hi - lo) / 2);
        mergeSortWithoutCopy(aux, a, lo, mid);
        mergeSortWithoutCopy(aux, a, mid + 1, hi);
        mergeWithoutCopy(a, aux, lo, mid, hi);
    }

    public static void mergeSortWithoutCopy(Comparable[] a) {
        Comparable[] aux = a.clone();
        mergeSortWithoutCopy(aux, a, 0, a.length - 1);
    }

    public static void bottomUpMergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz += sz) {
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
                mergeWithCopy(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }

    private static int partitionUnstable(Comparable[] a, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= hi && less(a[i], a[lo])) i++;
            while (j >= lo && less(a[lo], a[j])) j--;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void quickSortUnstable(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partitionUnstable(a, lo, hi);
        quickSortUnstable(a, lo, j - 1);
        quickSortUnstable(a, j + 1, hi);
    }

    public static void shuffleArray(Comparable[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Comparable a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void quickSortUnstable(Comparable[] a) {
        shuffleArray(a);
        quickSortUnstable(a, 0, a.length - 1);
    }

    private static void quickSortStable(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, gt--, i);
            else i++;
        }
        quickSortStable(a, lo, lt - 1);
        quickSortStable(a, gt + 1, hi);
    }

    public static void quickSortStable(Comparable[] a) {
        shuffleArray(a);
        quickSortStable(a, 0, a.length - 1);
    }

    public static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a, k / 2, k)) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    public static void sink(Comparable[] a, int N, int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j - 1, j + 1 - 1)) j++;
            if (!less(a, k - 1, j - 1)) break;
            exch(a, k - 1, j - 1);
            k = j;
        }
    }

    public static void heapSort(Comparable[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            exch(arr, 0, i);

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    private static void heapify(Comparable[] arr, int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;

        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            exch(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

}
