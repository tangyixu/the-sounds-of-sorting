package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {

    @SuppressWarnings("unused")
    private NoteIndices notes;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     *
     * @param notes the note indices
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Find the max integer of the array.
     *
     * @param arr
     * @return The maximum in the array.
     */
    public int max(Integer[] arr) {
        int max = 0;
        for (Integer i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int unitWidth = (int) (getWidth() / this.notes.getNotes().length);
        Integer[] bars = this.notes.getNotes();
        int unitHeight = getHeight() / max(bars);
        for (int n = 0; n < bars.length; n++) {
            if (this.notes.isHighlighted(bars[n])) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.GRAY);
            }
            g.fillRect(n * unitWidth, getHeight() - bars[n], unitWidth, bars[n] * unitHeight);
        }
    }
}
