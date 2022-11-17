package Server;

import java.util.Arrays;

public class Grid {

    /* Battleship board */
    private String board[][];

    private int rows;
    private int columns;

    public Grid() {
        this.rows = 10;
        this.columns = 10;
        this.board = new String[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                this.board[c][r] = "[ ]";
            }

        }
    }

    public Grid(int gridSize) {
        this.rows = gridSize;
        this.columns = gridSize;
        this.board = new String[gridSize][gridSize];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                this.board[c][r] = "[ ]";
            }
        }
    }

    public void displayGrid() {
        // System.out.println(Arrays.deepToString(this.board).replace("],", "]\n"));
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                System.out.print(this.board[c][r] + " ");
            }
            System.out.print('\n');
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

}
