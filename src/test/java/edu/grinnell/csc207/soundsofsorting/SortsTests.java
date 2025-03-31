package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;
import java.util.Arrays;

public class SortsTests {

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

    public static Integer[] makeTestArray() {
        return new Integer[]{
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void normalArrBubbleSort1() {
        Integer[] sample = {5, 4, 3, 2, 1};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.bubbleSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void sameValTestBubbleSort2() {
        Integer[] sample = {5, 5, 5, 5, 5};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.bubbleSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void oneValTestBubbleSort3() {
        Integer[] sample = {5};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.bubbleSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void normaltestInsertionSort1() {
        Integer[] sample = {3, 2, 5, 1, 9};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.insertionSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void edgeTestInsertionSort2() {
        Integer[] sample = {0};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.insertionSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void sameValTestInsertionSort3() {
        Integer[] sample = {0, 1, 2, 0, -1, 5, 0, 1};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.insertionSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void normaltestSelectionSort1() {
        Integer[] sample = {32, 56, 1, 3, 9, 0};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.selectionSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void repeatTestSelectionSort2() {
        Integer[] sample = {32, 56, 32, 1, 3, 9, 32, 0};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.selectionSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void nullTestSelectionSort3() {
        Integer[] sample = {};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.selectionSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void normalTestMergeSort1() {
        Integer[] sample = {8, 20, 13, 1, 8, 20, 13, 5};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.mergeSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void nullTestMergeSort2() {
        Integer[] sample = {};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.mergeSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void repeatTestMergeSort3() {
        Integer[] sample = {12, 1, 99, 0, 11, 1, 99};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.mergeSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void normalTestQuickSort1() {
        Integer[] sample = {8, 17, 10, 3, 1, 2};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.quickSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void nullTestQuickSort2() {
        Integer[] sample = {};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.quickSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void repeatTestQuickSort3() {
        Integer[] sample = {13, 1, 99, 13, 1, 99};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.quickSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void normalTestBongoSort1() {
        Integer[] sample = {8, 17, 10, 3, 1, 2};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.bongoSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void nullTestBongoSort2() {
        Integer[] sample = {};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.bongoSort(arrCopy));
        assertTrue(sorted(sample));
    }

    @Test
    public void repeatTestBongoSort3() {
        Integer[] sample = {13, 1, 99, 13, 1, 99};
        Integer[] arrCopy = Arrays.copyOf(sample, sample.length);
        Sorts.eventSort(sample, Sorts.bongoSort(arrCopy));
        assertTrue(sorted(sample));
    }
}
