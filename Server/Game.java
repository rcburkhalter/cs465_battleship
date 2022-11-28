package Server;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    /* A battleship player */
    Player player;

    /* Grid for the battleship game */
    Grid battleshipGrid;

    /* create a list of players for a game */
    ArrayList<Player> gamePlayers;

    Player activePlayer;

    int activePlayerNo;

    public Game() {
        gamePlayers = new ArrayList<>();
    }

    // public Game(String playerName, int gridSize) {

    // }

    public void addPlayers(Player player) {
        gamePlayers.add(player);
    }

    public void displayPlayers() {
        for (Player player : gamePlayers) {
            System.out.print(player.getPlayerName());
        }
    }

    public void displayBoards() {
        for (Player player : gamePlayers) {
            System.out.print(player.getPlayerName() + "'s " + "Batttleship Board: " + '\n');
            player.displayPlayerBoard();
        }
    }

    public void setInitialPlayer() {
        Random r = new Random();
        activePlayerNo = r.nextInt(gamePlayers.size());
        activePlayer = gamePlayers.get(activePlayerNo);
    }

    public void rotateActivePlayer() {
        if (activePlayerNo == gamePlayers.size() - 1) {
            activePlayerNo = 0;
        } else {
            activePlayerNo += 1;
        }
        activePlayer = gamePlayers.get(activePlayerNo);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
}
