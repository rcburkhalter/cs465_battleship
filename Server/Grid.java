package Server;

import java.util.Random;

/**
 * This class represents one player's board in Battleship
 * @author Ryan Burkhalter, Christopher Vines
 */
public class Grid {

    /* Battleship board */
    private char board[][];

    private int rows;
    private int columns;

    Random rand = new Random();

    private int numOfShips;
    /**
     * Initalizes grid
     */
    public Grid() {
        this.rows = 10;
        this.columns = 10;
        this.board = new char[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                this.board[c][r] = ' ';
            }

        }
    }
    /**
     * Alternate grid initialization given grid size
     * @param gridSize
     */
    public Grid(int gridSize) {
        this.rows = gridSize;
        this.columns = gridSize;
        this.board = new char[gridSize][gridSize];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                this.board[c][r] = ' ';
            }
        }
    }
    /**
     * Displays grid in full detail
     */
    public void displayGrid() {
        for (int c = 0; c < columns; c++) {
            System.out.print("   " + c);
        }
        System.out.println();
        System.out.print(" +");
        for (int c = 0; c < columns; c++) {
            System.out.print("---+");
        }
        System.out.println();
        for (int r = 0; r < rows; r++) {
            System.out.print(Integer.toString(r) + "|");
            for (int c = 0; c < columns; c++) {
                System.out.print(" " + this.board[c][r] + " |");
            }
            System.out.print('\n');
            System.out.print(" +");
            for (int c = 0; c < columns; c++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }
    /**
     * Used when players are viewing each other's board, prints only the hits and misses against target board
     */
    public void displayGridAsOther() {
        for (int c = 0; c < columns; c++) {
            System.out.print("   " + c);
        }
        System.out.println();
        System.out.print(" +");
        for (int c = 0; c < columns; c++) {
            System.out.print("---+");
        }
        System.out.println();
        for (int r = 0; r < rows; r++) {
            System.out.print(Integer.toString(r) + "|");
            for (int c = 0; c < columns; c++) {
                char temp = ' ';
                if (this.board[c][r] == 'X' || this.board[c][r] == 'O') {
                    temp = this.board[c][r];
                }
                System.out.print(" " + temp + " |");
            }
            System.out.print('\n');
            System.out.print(" +");
            for (int c = 0; c < columns; c++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }
    /**
     * returns the number of rows of the grid
     * @return number of rows
     */
    public int getRows() {
        return this.rows;
    }
    /**
     * returns number of columns in grid
     * @return number of columns
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Generates a number of ships based on the size of the board
     */
    public void generateNumOfShips() {

        if (this.rows == 10) {
            numOfShips = rand.nextInt(3) + 4;
        } else if (this.rows < 10 && this.rows > 7) {
            numOfShips = rand.nextInt(3) + 3;
        } else if (this.rows < 7 && this.rows > 6) {
            numOfShips = rand.nextInt(2) + 2;
        } else if (this.rows < 6) {
            numOfShips = rand.nextInt(2) + 1;
        }
    }
    /**
     * Adds a ship to the board
     * @param size size of ship
     * @param type type of ship
     */
    public void addShip(int size, ShipType type) {
        Ship ship = new Ship(size, type);
        ShipType shipType = ship.getShipType();

        int randNum = rand.nextInt(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == randNum) {
                    board[i][j] = shipType.toString().charAt(0);
                }
            }
        }

    }
    /**
     * creates one specific ship
     * @param size size of ship
     * @param type type of ship
     * @return ship with given parameters
     */
    public Ship createShip(int size, ShipType type) {
        Ship createdShip = new Ship(size, type);
        return createdShip;
    }

    /**
     * Creates a ship of random type
     * @return a random ship of the allowed types
     */
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
    /**
     * places ships
     */
    public void populateGrid() {
        generateNumOfShips();
        for (int i = 0; i < numOfShips; i++) {
            Ship tempship = createRandomShip();
            boolean horiz = rand.nextBoolean();
            if (horiz) {
                int srcx = rand.nextInt(board.length - tempship.getShipSize() + 1);
                int srcy = rand.nextInt(board[0].length);
                for (int j = 0; j < tempship.getShipSize(); j++) {
                    board[srcx + j][srcy] = tempship.getShipType().shipType.charAt(0);
                }
            } else {
                int srcy = rand.nextInt(board[0].length - tempship.getShipSize() + 1);
                int srcx = rand.nextInt(board.length);
                for (int j = 0; j < tempship.getShipSize(); j++) {
                    board[srcx][srcy + j] = tempship.getShipType().shipType.charAt(0);
                }
            }
        }
    }

    /**
     * returns if the player holding the board is still in the game
     * @return player alive status
     */
    public boolean getAlive() {
        boolean alive = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'S' || board[i][j] == 'B' || board[i][j] == 'C' || board[i][j] == 'D' || board[i][j] == 'R') {
                    alive = true;
                }
            }
        }
        return alive;
    }

    /**
     * processes shots against the grid
     * @param x target x coord
     * @param y target y coord
     * @return true if hit, false if miss
     */
    public boolean hit(int x, int y) {
        if (board[x][y] == 'S' || board[x][y] == 'B' || board[x][y] == 'C' || board[x][y] == 'D' || board[x][y] == 'R') {
            board[x][y] = 'X';
            return true;
        } else {
            board[x][y] = 'O';
            return false;
        }
    }
}
