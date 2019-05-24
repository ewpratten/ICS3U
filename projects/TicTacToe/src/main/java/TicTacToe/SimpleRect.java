package TicTacToe;

import java.awt.Color;
import java.awt.Point;

import hsa2.GraphicsConsole;

/**
 * An easy wrapper for a drawable rectangle
 */
public class SimpleRect {
    int x, y;
    int w, h;
    
    Boolean state;

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
        // Draw bg rect
        gc.setColor(Color.white);
        gc.fillRect(x, y, w, h);

        // Draw border
        gc.setColor(Color.black);
        gc.drawLine(x, y, x, y + h);
        gc.drawLine(x+w, y, x + w, y + h);
        gc.drawLine(x, y, x + w, y );
        gc.drawLine(x, y + h + h, x + w, y + h);

        if (state != null) {
            if (state) {
                gc.setColor(Color.black);

                // Draw lines
                gc.drawLine(x, y, x + w, y + h);
                gc.drawLine(x, y + h, x + w, y);

            } else {
                gc.setColor(Color.black);

                // Draw circle
                gc.drawOval(x, y, w, h);
            }
        }
    }
    
    /**
     * Set the truth of this rect
     */
    public void set(boolean x) {
        this.state = x;
    }

    public boolean isNull() {
        return this.state == null;
    }
}