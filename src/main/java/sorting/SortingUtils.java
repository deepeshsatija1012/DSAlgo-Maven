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
}
