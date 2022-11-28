package Server;

public class Player {

    /* Name for a player */
    String playerName;

    /* This players game board */
    Grid playerGrid;

    public Player(String name, Grid grid) {

        this.playerName = name;
        grid.populateGrid();
        this.playerGrid = grid;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void displayPlayerBoard() {
        this.playerGrid.displayGrid();
    }

    public Grid getGrid() {
        return playerGrid;
    }

    public boolean Fire(Player target, int x, int y) {
        return target.getGrid().hit(x, y);
    }
}
