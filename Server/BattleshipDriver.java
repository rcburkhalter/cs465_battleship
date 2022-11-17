package Server;

import java.util.Scanner;

public class BattleshipDriver {

    /* Instance of a battleship game */
    static Game game;

    /* User input */
    static Scanner keyboard = new Scanner(System.in);

    /* A battleship player */
    static Player player;

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: <file> <port num> [board size]");
        }

        if (args.length == 1) {
            game = setupGame(null);
            game.displayBoards();
        }

        if (args.length == 2) {
            game = setupGame(args[1]);
            game.displayBoards();

        }
    }

    public static Game setupGame(String gridSize) {
        Game gameSetup = new Game();
        System.out.println("Enter the number of players for this game: ");
        int numOfPlayers = keyboard.nextInt();
        int cnt = 0;

        if (gridSize == null) {
            while (cnt < numOfPlayers) {
                System.out.print("Enter a players name: ");
                player = new Player(keyboard.next(), new Grid());
                gameSetup.addPlayers(player);
                cnt++;
            }
        } else {
            while (cnt < numOfPlayers) {
                System.out.print("Enter a players name: ");
                player = new Player(keyboard.next(), new Grid(Integer.parseInt(gridSize)));
                gameSetup.addPlayers(player);
                cnt++;
            }
        }
        keyboard.close();
        return gameSetup;
    }
}
