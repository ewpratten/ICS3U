package LightsOut;

import java.awt.Color;
import java.awt.Point;

import hsa2.GraphicsConsole;

public class SimpleRect {
    int x, y;
    int w, h;
    
    boolean truth = false;

    public SimpleRect(Point loc, int width, int height) {
        this.w = width;
        this.h = height;

        this.x = (int) loc.getX();
        this.y = (int) loc.getY();
    }

    public void draw(GraphicsConsole gc) {
        if (truth) {
            gc.setColor(Color.cyan);
        } else {
            gc.setColor(Color.pink);
        }

        gc.fillRoundRect(x, y, w, h, 15, 15);
    }
    
    void set(boolean x) {
        this.truth = x;
    }

    boolean get() {
        return this.truth;
    }
}