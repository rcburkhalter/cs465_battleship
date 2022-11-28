package Server;

public class Player {

    /* Name for a player */
    String playerName;

    /* This players game board */
    Grid playeGrid;

    public Player(String name, Grid grid) {

        this.playerName = name;
        grid.populateGrid();
        this.playeGrid = grid;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void displayPlayerBoard() {
        this.playeGrid.displayGrid();
    }

}
