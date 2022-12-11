package Server;

import java.util.ArrayList;
import java.util.Random;

/**
 * Game class handles game operation
 * @author Ryan Burkhalter, Christopher Vines
 */
public class Game {

    /* A battleship player */
    Player player;

    /* Grid for the battleship game */
    Grid battleshipGrid;

    /* create a list of players for a game */
    ArrayList<Player> gamePlayers;
    Player activePlayer;
    int activePlayerNo;
    /**
     * constructor for game
     */
    public Game() {
        gamePlayers = new ArrayList<>();
    }

    // public Game(String playerName, int gridSize) {

    // }
    /**
     * adds a player to the game
     */
    public void addPlayers(Player player) {
        gamePlayers.add(player);
    }

    /**
     * displays a list of names of current players
     */
    public void displayPlayers() {
        for (Player player : gamePlayers) {
            System.out.println(player.getPlayerName());
        }
    }

    /**
     * prints every player's board to stdio
     */
    public void displayBoards() {
        for (Player player : gamePlayers) {
            System.out.print(player.getPlayerName() + "'s " + "Batttleship Board: " + '\n');
            player.displayPlayerBoard();
        }
    }

    /**
     * Picks a random player to be the first player
     */
    public void setInitialPlayer() {
        Random r = new Random();
        activePlayerNo = r.nextInt(gamePlayers.size());
        activePlayer = gamePlayers.get(activePlayerNo);
    }

    /**
     * rotates the active status to the next player
     */
    public void rotateActivePlayer() {
        if (activePlayerNo == gamePlayers.size() - 1) {
            activePlayerNo = 0;
        } else {
            activePlayerNo += 1;
        }
        activePlayer = gamePlayers.get(activePlayerNo);
    }

    /**
     * returns the currently active player
     * @return player whose turn it currently is
     */
    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * checks to see if there is a winner
     * @return null if no winner, returns the player who has won
     */
    public Player getWinner() {
        ArrayList<Player> playersInGame = new ArrayList<Player>();
        for (int i = 0; i < gamePlayers.size(); i++) {
            if (gamePlayers.get(i).getGrid().getAlive()) {
                playersInGame.add(gamePlayers.get(i));
            }
        }
        if (playersInGame.size() == 1) {
            return playersInGame.get(0);
        } else {
            return null;
        }
    }

    /**
     * returns a player by checking their names against the given string
     * @param fname player name to find
     * @return player with given name, null if no corresponding player
     */
    public Player findPlayer(String fname) {
        for (int i = 0; i < gamePlayers.size(); i++) {
            if (fname.equals(gamePlayers.get(i).getPlayerName())) {
                return gamePlayers.get(i);
            }
        }
        return null;
    }
}
