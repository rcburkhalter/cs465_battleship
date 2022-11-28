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
        int gameSize = 10;
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: <file> <port num> [board size]");
        }

        if (args.length == 1) {
            game = setupGame(gameSize);
            game.displayBoards();
        }

        if (args.length == 2) {
            gameSize = Integer.parseInt(args[1]);
            game = setupGame(gameSize);
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
                    String input = keyboard.next();
                    if (input.equals("1")|| input.equals("2") || input.equals("3")) {
                        choice = Integer.parseInt(input);
                        System.out.println("Your choice: " + Integer.toString(choice));
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
                    Player target = null;
                    while (target == null) {
                        target = game.findPlayer(keyboard.next());
                        if (target == null) {
                            System.out.println("invalid player");
                        }
                    }
                    System.out.println("Enter target X and then target Y coordinates (as indices)");
                    boolean validCoords = false;
                    int targx = 0;
                    int targy = 0;
                    while (!validCoords) {
                        try {
                            targx = keyboard.nextInt();
                            targy = keyboard.nextInt();
                            if (targx < gameSize && targy < gameSize) {
                                validCoords = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid coords. Try again");
                        }

                    }

                    if (game.getActivePlayer().Fire(target, targx, targy)) {
                        System.out.println("Hit");
                    } else {
                        System.out.println("Miss");
                    }
                    game.rotateActivePlayer();
                    if (game.getWinner() != null) {
                        System.out.println("Congratulations " + game.getWinner().getPlayerName() + ", you won!");
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    public static Game setupGame(int gridSize) {
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

        if (gridSize == 10) {
            while (cnt < numOfPlayers) {
                System.out.print("Enter a players name: ");
                player = new Player(keyboard.next(), new Grid());
                gameSetup.addPlayers(player);
                cnt++;
            }
        } else {
            while (cnt < numOfPlayers) {
                System.out.print("Enter a players name: ");
                player = new Player(keyboard.next(), new Grid(gridSize));
                gameSetup.addPlayers(player);
                cnt++;
            }
        }
        gameSetup.setInitialPlayer();
        return gameSetup;
    }
}
