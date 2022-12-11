package Client;
import Client.BattleClient;

/**
 * This class is the driver for the client side, the user interacts with the program through this
 * @author Ryan Burkhalter
 */
public class BattleDriver {
    BattleClient bc;
    /**
     * The main method, it all traces back to this
     * @param args I don't think it's necessary to describe args
     */
    public static void main(String[] args) {
        BattleClient bc = new BattleClient();
        if (args.length != 3) {
            System.out.println("Invalid number of args");
            System.out.println("Usage: <host> <port num> <username>");
            System.exit(1);
        }

    }
}
