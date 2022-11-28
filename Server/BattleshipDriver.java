package Server;
import Server.*;

import java.util.InputMismatchException;
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

        boolean gameOver = false;
        while (!gameOver) {
            int choice = 0;
            boolean choiceMade = false;
            System.out.println("It is " + game.getActivePlayer().getPlayerName() + "'s turn");
            System.out.println("Options:");
            System.out.println("1: Fire");
            System.out.println("2: Display board");
            System.out.println("3: Surrender");
            while (!choiceMade) {
                try {
                    choice = keyboard.nextInt();
                    if (choice == 1 || choice == 2 || choice == 3) {
                        choiceMade = true;
                    } else {
                        System.out.println("Invalid choice. Try again. (1: Fire; 2: Display board; 3: Surrender)");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid entry. Try again. (1: Fire; 2: Display board; 3: Surrender)");
                }
            }
            switch (choice) {
                case 2:
                    game.getActivePlayer().displayPlayerBoard();
                    break;
            }
            game.rotateActivePlayer();
        }
    }

    public static Game setupGame(String gridSize) {
        Game gameSetup = new Game();
        try {
            System.out.println("Enter the number of players for this game: ");
        } catch (InputMismatchException e) {
            System.out.println("Invalid number of players. Closing program");
            System.exit(1);
        }

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
        gameSetup.setInitialPlayer();
        return gameSetup;
    }
}
