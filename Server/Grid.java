package Server;

import java.util.Arrays;
import java.util.Random;

public class Grid {

    /* Battleship board */
    private String board[][];

    private int rows;
    private int columns;

    private int numOfShips;

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

    public void generateNumOfShips() {
        Random rand = new Random();

        if (this.rows == 10) {
            numOfShips = rand.nextInt(4, 6);
        } else if (this.rows < 10 && this.rows > 7) {
            numOfShips = rand.nextInt(3, 5);
        } else if (this.rows < 7 && this.rows > 6) {
            numOfShips = rand.nextInt(2, 3);
        } else if (this.rows < 6) {
            numOfShips = rand.nextInt(1, 2);
        }
    }

}
