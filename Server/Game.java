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
            System.out.println(player.getPlayerName());
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

    public Player findPlayer(String fname) {
        for (int i = 0; i < gamePlayers.size(); i++) {
            if (fname.equals(gamePlayers.get(i).getPlayerName())) {
                return gamePlayers.get(i);
            }
        }
        return null;
    }
}
