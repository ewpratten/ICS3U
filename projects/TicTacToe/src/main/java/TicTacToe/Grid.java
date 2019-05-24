package TicTacToe;

import java.awt.Point;

import hsa2.GraphicsConsole;
import java.util.ArrayList;

/** 
 * A mesh2D of rects
 */
public class Grid {
    int size;
    int rSize;

    SimpleRect[][] mesh;

    /**
     * Create a Grid with a rect size, width, and height
     * 
     * @param size Width of the contained SimpleRects
     * @param w Width of the window in px
     * @param h Height of the window in px
     */
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
                // Find starting coords
                int x = j * rSize;
                int y = i * rSize;

                // Construct the SimpleRect
                Point loc = new Point(x, y);
                mesh[i][j] = new SimpleRect(loc, rSize, rSize);
                j++;
            }
            i++;
        }

        System.out.println("[Grid] A grid has been successfully built with a size of: "+ w +" x "+ h +". With a spacing of: "+ size);
    }
    
    /**
     * Calls through to all SimpleRects, and shows them on gc
     * 
     * @param gc The GraphicsConsole to show the SimpleRacts on
     */
    public void display(GraphicsConsole gc) {
        // Iterate through mesh and draw
        synchronized (gc) {
            gc.clear();
            for (SimpleRect[] row : mesh) {
                for (SimpleRect square : row) {

                    // Draw the SimpleRect
                    square.draw(gc);
                }
            }
        }
    }

    /**
     * Has someone won or tied?
     */
    public int checkState() {
        int state = 0;

        int row_counter = 0;
        int col_counter = 0;
        int diag_counter = 0;

        // Check winner
        for (int i = 0; i < mesh.length; i++) {
            for (int j = 0; j < mesh.length; j++) {
                // Set the row
                row_counter += check(mesh[i][j]);

                // set the col
                col_counter += check(mesh[j][i]);

                // set the diag
                diag_counter += check(mesh[j][j]);
            }
        
            // Check the col and row counters, return if needed
            if (row_counter >= mesh.length)
                return 2;
            
            if (row_counter <= -mesh.length)
                return 3;
            
            if (col_counter >= mesh.length)
                return 2;
            
            if (col_counter <= -mesh.length)
                return 3;
            
            // System.out.println(row_counter + " " + col_counter + " " + diag_counter);

            // Reset the per-row counters
            row_counter = 0;
            col_counter = 0;
        }
        
        // Check the diagonal counter, return if needed
        diag_counter /= mesh.length;

        if (diag_counter >= mesh.length)
                return 2;
            
        if (diag_counter <= -mesh.length)
            return 3;

        // Check tie
        for (SimpleRect[] row : mesh) {
            for (SimpleRect square : row) {
                if (square.isNull()) {
                    return 0;
                }
            }
        }
        return 1;
    }
    
    // Turn a SimpleRect to an int
    private int check(SimpleRect rect) {
        if (rect.isNull()) {
            return 0;
        }

        if (rect.state == false) {
            return -1;
        }

        if (rect.state == true) {
            return 1;
        }

        return 0;
    }

    /**
     * Convert a mouse location into an array position, then call flipCross with the new location
     * 
     * @param loc Mouse Point
     * @param player Is the current player an X? or an O?
     */
    public void addressPoint(Point loc, boolean player) {
        // Get X and Y
        int x = (int) loc.getX();
        int y = (int) loc.getY();

        // Convert to col and row
        int col = x / rSize;
        int row = y / rSize;

        // Call drawing method
        mesh[row][col].set(player);
    }

    public boolean checkPoint(Point loc) {
        // Get X and Y
        int x = (int) loc.getX();
        int y = (int) loc.getY();

        // Convert to col and row
        int col = x / rSize;
        int row = y / rSize;

        return mesh[row][col].isNull();
    }
    
}