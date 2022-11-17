package Server;

import java.util.ArrayList;

public class Game {

    /* A battleship player */
    Player player;

    /* Grid for the battleship game */
    Grid battleshipGrid;

    /* create a list of players for a game */
    ArrayList<Player> gamePlayers;

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

}
