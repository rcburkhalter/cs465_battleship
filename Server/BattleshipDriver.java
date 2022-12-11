package Server;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * this class handles the operation of the battleship game from the server side
 * @author Ryan Burkhalter, Christopher vines
 */
public class BattleshipDriver {

    /* Instance of a battleship game */
    static Game game;

    /* User input */
    static Scanner keyboard = new Scanner(System.in);

    /* A battleship player */
    static Player player;

    /**
     * main
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int gameSize = 10;
        BattleServer bs;
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: <file> <port num> [board size]");
            System.exit(1);
        }

        int portno = 0;
        try {
            portno = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            
        }

        int numOfPlayers = 0;
        boolean validNum = false;
        while (!validNum) {
            try {
                System.out.println("Enter the number of players for this game: ");
                numOfPlayers = keyboard.nextInt();
                validNum = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number of players. Please try again");
            }
        }


        if (args.length == 1) {
            game = setupGame(gameSize, numOfPlayers);
            game.displayBoards();
        }

        if (args.length == 2) {
            gameSize = Integer.parseInt(args[1]);
            game = setupGame(gameSize, numOfPlayers);
            game.displayBoards();
        }
        try {
            bs = new BattleServer(portno, numOfPlayers);
        } catch (IOException e) {
            System.out.println("An error occured initializing the server. Aborting program");
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
            System.out.println("4: View other player's board");
            while (!choiceMade) {
                try {
                    String input = keyboard.next();
                    if (input.equals("1")|| input.equals("2") || input.equals("3") || input.equals("4")) {
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
                            } else{System.out.println("Invalid coords. Try again");}
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
                case 4:
                    System.out.println("Select player to view board");
                    game.displayPlayers();
                    Player toView = null;
                    while (toView == null) {
                        toView = game.findPlayer(keyboard.next());
                        if (toView == null) {
                            System.out.println("Invalid player");
                        }
                        toView.getGrid().displayGridAsOther();
                    }

            }
        }
    }

    /**
     * This method sets up a game of battleship, making the grids and players
     * @param gridSize desired size of play grid (one dimension of a square)
     * @param numOfPlayers desired number of players
     * @return set up game
     */
    public static Game setupGame(int gridSize, int numOfPlayers) {
        Game gameSetup = new Game();
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
