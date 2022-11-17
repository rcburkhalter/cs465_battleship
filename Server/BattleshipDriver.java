package Server;

public class BattleshipDriver {

    /* Instance of a battleship game */
    static Game game;

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: <file> <port num> [board size]");
        }

        if (args.length == 1) {
            game = new Game();
            game.displayGame();
        }

        if (args.length == 2) {
            game = new Game(Integer.parseInt(args[1]));
            game.displayGame();
        }
    }
}
