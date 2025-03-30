package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 *
 * @param <T>
 */
public class CopyEvent<T> implements SortEvent<T> {

    private List<Integer> affectedIndices;
    private int curIndex;
    private T value;

    /**
     * Construct a new copyEvent.
     *
     * @param index the destination index
     * @param value the value to be copied
     */
    public CopyEvent(int index, T value) {
        this.affectedIndices = new ArrayList<>();
        this.affectedIndices.add(index);
        this.curIndex = index;
        this.value = value;
    }

    /**
     * Applies this event to the array.
     *
     * @param arr the array to modify
     */
    @Override
    public void apply(T[] arr) {
        arr[this.curIndex] = this.value;
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
