package Server;

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
            System.out.println("3: Quit");
            while (!choiceMade) {
                try {
                    choice = keyboard.nextInt();
                    if (choice == 1|| choice == 2 || choice == 3) {
                        System.out.println("Your choice: ");
                        choiceMade = true;
                    } else {
                        System.out.println("Invalid choice. Try again. (1: Fire; 2: Display board; 3: Quit)");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid entry. Try again. (1: Fire; 2: Display board; 3: Quit)");
                }
            }
            switch (choice) {
                case 2:
                    game.getActivePlayer().displayPlayerBoard();
                    break;
                case 3:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Select target to fire upon:");
                    game.displayPlayers();
                    Player target = game.findPlayer(keyboard.next());
                    if (target == null) {
                        System.out.println("invalid player");
                    }
                    System.out.println("Enter target X and then target Y coordinates");
                    int targx = keyboard.nextInt();
                    int targy = keyboard.nextInt();
                    if (game.getActivePlayer().Fire(target, targx, targy)) {
                        System.out.println("Hit");
                    } else {
                        System.out.println("Miss");
                    }
                    game.rotateActivePlayer();
                    if (game.getWinner() != null) {
                        System.out.println("Congratulations " + game.getWinner().getPlayerName() + ", you won!");
                    }
                    break;
            }
        }
    }

    public static Game setupGame(String gridSize) {
        Game gameSetup = new Game();
        int numOfPlayers = 0;
        try {
            System.out.println("Enter the number of players for this game: ");
            numOfPlayers = keyboard.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number of players. Closing program");
            System.exit(1);
        }

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
