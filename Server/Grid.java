package Server;

import java.util.ArrayList;
import java.util.Random;

public class Grid {

    /* Battleship board */
    private String board[][];

    private int rows;
    private int columns;

    Random rand = new Random();

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

        if (this.rows == 10) {
            numOfShips = rand.nextInt(2) + 4;
        } else if (this.rows < 10 && this.rows > 7) {
            numOfShips = rand.nextInt(2) + 3;
        } else if (this.rows < 7 && this.rows > 6) {
            numOfShips = rand.nextInt(1) + 2;
        } else if (this.rows < 6) {
            numOfShips = rand.nextInt(1) + 1;
        }
    }

    public void addShip(int size, ShipType type) {
        Ship ship = new Ship(size, type);
        ShipType shipType = ship.getShipType();

        int randNum = rand.nextInt(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == randNum) {
                    board[i][j] = shipType.toString();
                }
            }
        }

    }

    public Ship createShip(int size, ShipType type) {
        Ship createdShip = new Ship(size, type);
        return createdShip;
    }

    public Ship createRandomShip() {
        ShipType[] ships;
        ships = ShipType.values();
        Ship ship;

        int randNum = rand.nextInt(ships.length);
        switch (randNum) {
            case 0:
                ship = new Ship(2, ShipType.CARRIER);
                break;
            case 1:
                ship = new Ship(3, ShipType.SUBMARINE);
                break;
            case 2:
                ship = new Ship(3, ShipType.BATTLESHIP);
                break;
            case 3:
                ship = new Ship(4, ShipType.CRUISER);
                break;
            default:
                ship = new Ship(5, ShipType.DESTROYER);
        }

        return ship;
    }

}
