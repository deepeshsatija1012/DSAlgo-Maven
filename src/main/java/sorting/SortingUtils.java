package sorting;

public class SortingUtils {

    private static void exch (Comparable[] arr, int i, int j) {
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
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = i ; j > 0 ; j--) {
                if (less(a, j, j-1)) {
                    exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void selectionSort(Comparable[] a) {
        for (int i = 0 ; i < a.length ; i++ ) {
            int min = i;
            for (int j = i + 1 ; j < a.length ; j++) {
                if (less(a, j, min)) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void insertionSort(Comparable[] a) {
        for (int i = 0 ; i < a.length ; i++ ) {
            for (int j = i ; j > 0 ; j--) {
                if (less(a, j, j-1)) {
                    exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void shellSort(Comparable[] a) {
        int h = 1;
        while (h < a.length/3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h ; i < a.length ; i++ ) {
                for (int j = i; j >= h ; j -= h) {
                    if (less(a, j, j-h)) {
                        exch(a, j, j-h);
                    } else {
                        break;
                    }
                }
            }
            h = h/3;
        }
    }

    private static void mergeWithCopy(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo ; k <= hi ; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo ; k <= hi ; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux, j, i)) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void mergeSortWithCopy(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + ( (hi - lo) / 2);
        mergeSortWithCopy(a, aux, lo, mid);
        mergeSortWithCopy(a, aux, mid+1, hi);
        mergeWithCopy(a, aux, lo, mid, hi);
    }

    public static void mergeSortWithCopy(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSortWithCopy(a, aux, 0, a.length - 1);
    }

    private static void mergeWithoutCopy(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo ; k <= hi ; k++) {
            if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else if (less(a, j, i)) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
    }

    private static void mergeSortWithoutCopy(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + ( (hi - lo) / 2);
        mergeSortWithoutCopy(aux, a, lo, mid);
        mergeSortWithoutCopy(aux, a, mid+1, hi);
        mergeWithoutCopy(a, aux, lo, mid, hi);
    }

    public static void mergeSortWithoutCopy(Comparable[] a) {
        Comparable[] aux = a.clone();
        mergeSortWithoutCopy(aux, a, 0, a.length - 1);
    }

    public static void bottomUpMergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        for (int sz = 1 ; sz < a.length ; sz += sz) {
            for (int lo = 0 ; lo < a.length-sz ; lo += sz + sz) {
                mergeWithCopy(a, aux, lo, lo + sz - 1, Math.min(lo+sz+sz-1, a.length-1));
            }
        }
    }
}
