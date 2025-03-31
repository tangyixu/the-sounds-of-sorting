package edu.grinnell.csc207.soundsofsorting.sorts;

import edu.grinnell.csc207.soundsofsorting.sortevents.CompareEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.CopyEvent;
import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SwapEvent;
import java.util.ArrayList;
import java.util.Arrays;

//import edu.grinnell.csc207.soundsofsorting.SortsTests;
/**
 * A collection of sorting algorithms.
 */
public class Sorts {

    /**
     * Swaps indices <code>i</code> and <code>j</code> of array
     * <code>arr</code>.
     *
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> bubbleSort(T[] arr) {
        List<SortEvent<T>> result = new ArrayList<>();
        for (int n = arr.length - 1; n > 0; n--) {
            for (int m = 0; m < n; m++) {
                if (arr[m].compareTo(arr[m + 1]) > 0) {
                    //swap(arr, m, m + 1);
                    CompareEvent<T> comE = new CompareEvent<>(m, m + 1);
                    SwapEvent<T> swapE = new SwapEvent<>(m, m + 1);
                    result.add(comE);
                    result.add(swapE);
                }
            }
        }
        //
        return result;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> selectionSort(
            T[] arr) {
        List<SortEvent<T>> result = new ArrayList<>();
        for (int m = 0; m < arr.length - 1; m++) {
            int min = m;
            for (int n = m + 1; n < arr.length; n++) {
                if (arr[n].compareTo(arr[min]) < 0) {
                    CompareEvent<T> comE = new CompareEvent<>(n, min);
                    result.add(comE);
                    min = n;
                }
            }
            swap(arr, m, min);
            SwapEvent<T> swapE = new SwapEvent<>(m, min);
            result.add(swapE);
        }
        return result;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> insertionSort(
            T[] arr) {
        List<SortEvent<T>> result = new ArrayList<>();
        for (int n = 1; n < arr.length; n++) {
            int index = n;
            for (int m = n - 1; m >= 0; m--) {
                if (arr[m].compareTo(arr[index]) > 0) {
                    CompareEvent<T> comE = new CompareEvent<>(m, index);
                    result.add(comE);
                    swap(arr, m, index);
                    SwapEvent<T> swapE = new SwapEvent<>(m, index);
                    result.add(swapE);
                    index = m;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param <T> the carrier type of the array
     * @param arr1 the array to merge
     * @param arr2 the array to merge (we assume both arr1 and arr2 are sorted
     * from the smallest to the largest
     * @return a list of sorted events
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> merge(T[] arr1, T[] arr2) {
        //T[] result = (T[]) new Comparable[arr1.length + arr2.length];
        List<SortEvent<T>> sortE = new ArrayList<>();
        if (arr1.length != 0 && arr2.length != 0) {
            int i = 0, j = 0, k = 0;
            while (i < arr1.length && j < arr2.length) {
                CompareEvent<T> comE = new CompareEvent<>(i, j + arr1.length);
                sortE.add(comE);
                if (arr1[i].compareTo(arr2[j]) <= 0) {
                    //result[k++] = arr1[i++];
                    CopyEvent<T> copyE = new CopyEvent<>(k++, arr1[i++]);
                    sortE.add(copyE);
                } else {
                    //result[k++] = arr2[j++];
                    CopyEvent<T> copyE = new CopyEvent<>(k++, arr2[j++]);
                    sortE.add(copyE);
                }
            }
            while (i < arr1.length) {
                //result[k++] = arr1[i++];
                CopyEvent<T> copyE = new CopyEvent<>(k++, arr1[i++]);
                sortE.add(copyE);
            }
            while (j < arr2.length) {
                //result[k++] = arr2[j++];
                CopyEvent<T> copyE = new CopyEvent<>(k++, arr2[j++]);
                sortE.add(copyE);
            }
        }
        return sortE;
    }

    /**
     * Sorts the array according to the merge sort algorithm.
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> mergeSort(
            T[] arr) {
        List<SortEvent<T>> result = new ArrayList<>();
        if (arr.length > 1) {
            int mid = arr.length / 2;
            T[] left = (T[]) new Comparable[mid];
            T[] right = (T[]) new Comparable[arr.length - mid];
            //System.arraycopy(arr, 0, left, 0, mid);
            //System.arraycopy(arr, mid, right, 0, arr.length - mid);
            for (int n = 0; n < arr.length; n++) {
                if (n < mid) {
                    left[n] = arr[n];
                    CopyEvent<T> copyE = new CopyEvent<>(n, arr[n]);
                    result.add(copyE);
                } else {
                    right[n - mid] = arr[n];
                    CopyEvent<T> copyE = new CopyEvent<>(n - mid, arr[n]);
                    result.add(copyE);
                }
            }
            for (int n = 0; n < arr.length; n++) {
                CopyEvent<T> copyE = new CopyEvent<>(n, arr[n]);
                result.add(copyE);
            }
            result.addAll(mergeSort(left));
            result.addAll(mergeSort(right));
            result.addAll(merge(left, right));
            //System.arraycopy(merged, 0, arr, 0, merged.length);
        }
        return result;
    }

    /**
     * Return the sorted event.
     *
     * @param <T>
     * @param arr
     * @return the pivot value in the last list in returned sorted event array.
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> partition(T[] arr) {
        List<SortEvent<T>> sortE = new ArrayList<>();
        if (arr.length != 0) {
            int i = -1;
            int j = 0;
            T pivot;

            pivot = arr[arr.length - 1];
            while (j < arr.length - 1) {
                CompareEvent<T> comE = new CompareEvent<>(j, arr.length - 1);
                sortE.add(comE);
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    //swap(arr, i, j);
                    SwapEvent<T> swapE = new SwapEvent<>(i, j);
                    sortE.add(swapE);
                }
                j++;
            }
            //swap(arr, i + 1, arr.length - 1);
            SwapEvent<T> swapE = new SwapEvent<>(i + 1, arr.length - 1);
            sortE.add(swapE);
            //return i + 1;
            CopyEvent<T> copyE = new CopyEvent<>(i + 1, arr[i + 1]);
            sortE.add(copyE);
        }
        return sortE;
    }

    /**
     * Return a sort event based of quick sort algorithm.
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> quickSort(T[] arr) {
        List<SortEvent<T>> result = new ArrayList<>();
        List<SortEvent<T>> sortE = partition(arr);
        if (arr.length > 1) {
            int pivot = sortE.get(sortE.size() - 1).getAffectedIndices().get(0);
            sortE.remove(sortE.size() - 1);
            result.addAll(sortE);
            T[] left = (T[]) new Comparable[pivot];
            T[] right = (T[]) new Comparable[arr.length - pivot - 1];
            //System.arraycopy(arr, 0, left, 0, pivot);
            //System.arraycopy(arr, pivot + 1, right, 0, arr.length - pivot - 1);
            for (int n = 0; n < arr.length; n++) {
                if (n <= pivot) {
                    CopyEvent<T> copyE = new CopyEvent<>(n, left[n]);
                    result.add(copyE);
                } else {
                    CopyEvent<T> copyE = new CopyEvent<>(n, right[n - pivot]);
                    result.add(copyE);
                }
            }
            result.addAll(quickSort(left));
            result.addAll(quickSort(right));
            //System.arraycopy(left, 0, arr, 0, left.length);
            //System.arraycopy(right, 0, arr, pivot + 1, right.length);
        }
        return result;
    }

    /**
     * Return a sort event based of bongo sort algorithm.
     *
     * @param <T>
     * @param arr
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> bongoSort(T[] arr) {
        List<SortEvent<T>> sortE = new ArrayList<>();
        T[] hold = Arrays.copyOf(arr, arr.length);
        while (true) {
            for (int n = 0; n < arr.length; n++) {
                int random = (int) (Math.random() * arr.length);
                SwapEvent<T> swapE = new SwapEvent<>(random, n);
                sortE.add(swapE);
            }
            eventSort(hold, sortE);
            if (Sorts.sorted(hold)) {
                break;
            }
            sortE.clear();
        }
        return sortE;
    }

    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Apply a list of events to the list in-order.
     *
     * @param <T>
     * @param l
     * @param events
     */
    public static <T> void eventSort(T[] l, List<SortEvent<T>> events) {
        for (SortEvent se : events) {
            se.apply(l);
        }
    }
}
