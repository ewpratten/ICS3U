package LightsOut;

import java.awt.Color;
import java.awt.Point;

import hsa2.GraphicsConsole;

/**
 * An easy wrapper for a drawable rectangle
 */
public class SimpleRect {
    int x, y;
    int w, h;
    
    boolean truth = false;

    /**
     * Create a rectangle at a location, with a known size
     * 
     * @param loc X, Y Point to draw rect
     * @param width Width in px
     * @param height Height in px
     */
    public SimpleRect(Point loc, int width, int height) {
        this.w = width;
        this.h = height;

        this.x = (int) loc.getX();
        this.y = (int) loc.getY();
    }

    /**
     * Draws the rect on a given GraphicsConsole
     * 
     * @param gc GraphicsConsole to draw on
     */
    public void draw(GraphicsConsole gc) {
        if (truth) {
            gc.setColor(Color.cyan);
        } else {
            gc.setColor(Color.pink);
        }

        gc.fillRoundRect(x, y, w, h, 15, 15);
    }
    
    /**
     * Set the truth of this rect
     */
    void set(boolean x) {
        this.truth = x;
    }

    /**
     * Get the truth of this rect
     */
    boolean get() {
        return this.truth;
    }
}