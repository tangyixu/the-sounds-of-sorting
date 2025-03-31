package edu.grinnell.csc207.soundsofsorting;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;
import java.util.ArrayList;
import java.util.List;

/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {

    private Integer[] noteIndices;
    public List<Integer> highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an initial
     * starting point for the sorting process.
     *
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        this.noteIndices = new Integer[n];
        this.highlighted = new ArrayList<>();
        for (int m = 0; m < n; m++) {
            noteIndices[m] = m;
        }
        for (int index = n - 1; index > 0; index--) {
            int random = (int) (Math.random() * (index + 1));
            Sorts.swap(this.noteIndices, random, index);
        }
    }

    /**
     * @return the indices of this NoteIndices object
     */
    public Integer[] getNotes() {
        return this.noteIndices;
    }

    /**
     * Highlights the given index of the note array
     *
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlighted.add(index);
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return this.highlighted.contains(index);
    }

    /**
     * Clears all highlighted indices from this collection
     */
    public void clearAllHighlighted() {
        this.highlighted.clear();
    }
}
