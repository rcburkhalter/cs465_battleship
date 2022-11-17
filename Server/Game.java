package Server;

public class Game {

    /* Grid for the battleship game */
    Grid battleshipGrid;

    public Game() {
        battleshipGrid = new Grid();

    }

    public Game(int gridSize) {
        battleshipGrid = new Grid(gridSize);

    }

    public void displayGame() {
        battleshipGrid.displayGrid();
    }

}
