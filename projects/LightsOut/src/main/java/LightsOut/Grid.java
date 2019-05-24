package LightsOut;

import java.awt.Point;

import hsa2.GraphicsConsole;
import java.util.ArrayList;

public class Grid {
    int size;
    int rSize;

    SimpleRect[][] mesh;

    public Grid(int size, int w, int h) {
        this.size = size;

        this.mesh = new SimpleRect[size][size];

        // calc rect size based on grid and window
        rSize = (int) (w / size);

        // Fill the mesh with objects
        int i = 0;
        for (SimpleRect[] row : mesh) {
            int j = 0;
            for (SimpleRect square : row) {
                int x = j * rSize;
                int y = i * rSize;

                Point loc = new Point(x, y);
                mesh[i][j] = new SimpleRect(loc, rSize, rSize);
                j++;
            }
            i++;
        }

        // Set the centre point
        mesh[mesh.length / 2][mesh.length / 2].set(true);

    }
    
    public void display(GraphicsConsole gc) {
        // Iterate through mesh and draw
        synchronized (gc) {
            gc.clear();
            for (SimpleRect[] row : mesh) {
                for (SimpleRect square : row) {
                    square.draw(gc);
                }
            }
        }
    }

    /**
     * Is the board entirely true?
     */
    public boolean isFull() {
        for (SimpleRect[] row : mesh) {
            for (SimpleRect square : row) {
                if (!square.get()) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public void addressPoints(Point loc) {
        int x = (int) loc.getX();
        int y = (int) loc.getY();

        int col = x / rSize;
        int row = y / rSize;

        flipCross(col, row);
    }
    
    private void flipCross(int x, int y) {
        // List of grids to flip
        ArrayList<Integer> xsections = new ArrayList<Integer>();
        ArrayList<Integer> ysections = new ArrayList<Integer>();

        // Add current point by default
        xsections.add(x);
        ysections.add(y);

        // Check surrondings
        if (x != 0) {
            xsections.add(x - 1);
            ysections.add(y);
        }
        
        if (x != mesh.length - 1) {
            xsections.add(x + 1);
            ysections.add(y);
        }

        if (y != 0) {
            xsections.add(x);
            ysections.add(y - 1);
        }
        
        if (y != mesh.length - 1) {
            xsections.add(x);
            ysections.add(y + 1);
        }

        // Iterate through valid sections and flip
        int i = 0;
        for (int vx : xsections) {
            mesh[ysections.get(i)][vx].set(!mesh[ysections.get(i)][vx].get());

            i++;
        }
    }
}