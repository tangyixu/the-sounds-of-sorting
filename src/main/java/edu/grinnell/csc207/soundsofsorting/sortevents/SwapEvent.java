package edu.grinnell.csc207.soundsofsorting.sortevents;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;
import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 *
 * @param <T> a generic type T
 */
public class SwapEvent<T> implements SortEvent<T> {

    private List<Integer> affectedIndices;
    private int pos1;
    private int pos2;

    /**
     * Construct a new swapEvent.
     *
     * @param index1 the first index of value being swapped.
     * @param index2 the first index of value being swapped.
     */
    public SwapEvent(int index1, int index2) {
        this.affectedIndices = new ArrayList<>();
        this.affectedIndices.add(index1);
        this.affectedIndices.add(index2);
        this.pos1 = index1;
        this.pos2 = index2;
    }

    /**
     * Applies this event to the array.
     *
     * @param arr the array to modify
     */
    @Override
    public void apply(T[] arr) {
        Sorts.swap(arr, this.pos1, this.pos2);
    }

    /**
     * @return a list of the indices affected by this event
     */
    @Override
    public List<Integer> getAffectedIndices() {
        return this.affectedIndices;
    }

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    @Override
    public boolean isEmphasized() {
        return true;
    }
}
