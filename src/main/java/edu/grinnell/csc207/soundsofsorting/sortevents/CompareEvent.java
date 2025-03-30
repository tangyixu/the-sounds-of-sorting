package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 *
 * @param <T> a generic type T
 */
public class CompareEvent<T> implements SortEvent<T> {

    private List<Integer> affectedIndices;

    /**
     * Construct a new compareEvent.
     *
     * @param index1 the first index being compared
     * @param index2 the second index being compared
     */
    public CompareEvent(int index1, int index2) {
        this.affectedIndices = new ArrayList<>();
        this.affectedIndices.add(index1);
        this.affectedIndices.add(index2);
    }

    /**
     * Applies this event to the array.
     *
     * @param arr the array to modify
     */
    @Override
    public void apply(T[] arr) {
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
        return false;
    }
}
