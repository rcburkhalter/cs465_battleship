package Server;

/**
 * One player of battleship
 * @author Ryan Burkhalter, Christopher Vines
 */
public class Player {

    /* Name for a player */
    String playerName;

    /* This players game board */
    Grid playerGrid;

    /**
     * player constructor
     * @param name desired player name
     * @param grid grid to assign to player
     */
    public Player(String name, Grid grid) {

        this.playerName = name;
        grid.populateGrid();
        this.playerGrid = grid;
    }

    /**
     * returns player name
     * @return player name
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * displays player's assigned grid
     */
    public void displayPlayerBoard() {
        this.playerGrid.displayGrid();
    }

    /**
     * returns player's grid
     * @return grid assigned to player
     */
    public Grid getGrid() {
        return playerGrid;
    }

    /**
     * fires against another player's board
     * @param target player to fire at
     * @param x target coord
     * @param y target coord
     * @return true if hit, false if miss
     */
    public boolean Fire(Player target, int x, int y) {
        return target.getGrid().hit(x, y);
    }
}
