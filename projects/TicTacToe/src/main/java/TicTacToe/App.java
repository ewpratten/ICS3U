/**
 * TicTacToe 
 * By: Evan Pratten
 * 
 * This game contains highly reusable code that can be translated over to other grid-based games.
 * There is also tidy logging of the states of the game
 */
package TicTacToe;

import hsa2.GraphicsConsole;
import java.awt.Color;
import java.awt.Point;

public class App {
    static int size = 3;

    static GraphicsConsole gc = new GraphicsConsole(600, 600, "Lights Out");

    static Grid gameBoard;

    public static void main(String[] args) {
        System.out.println("[APP] Starting game");

        new App();
    }

    App() {
        // Setup
        gameBoard = new Grid(size, gc.getDrawWidth(), gc.getDrawHeight());

        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.setBackgroundColor(Color.black);
        gc.clear();
        gc.enableMouse();

        System.out.println("[Game] Setup complete. Starting game loop");

        boolean player = false; // false = x, true = o

        // loop
        while (gameBoard.checkState() == 0) {
            // When mouse clicked, deal with state changes
            if (gc.getMouseClick() >= 1) {
                int x = gc.getMouseX();
                int y = gc.getMouseY();

                Point loc = new Point(x, y);

                // If the space is blank, plot marker, then switch player
                if (gameBoard.checkPoint(loc)) {
                    gameBoard.addressPoint(loc, player);

                    player = !player;
                }
                
            }

            // Display the next frame
            gameBoard.display(gc);
            gc.sleep(5);
        }

        // Game end
        int game_type = gameBoard.checkState(); // 1 = tie, 2 = x, 3 = o

        gc.clear();
        gc.setColor(Color.white);

        // Check winner type, and print
        if (game_type != 1) {

            String player_str = (game_type == 2) ? "X" : "O";
            gc.print(player_str + " has won the game");

            System.out.println("[Game] " + player_str + " has won the game");
        } else {
            gc.print("Game tied!");

            System.out.println("[Game] Game tied");
        }
        
    }
}
