package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Common.ConnectionAgent;
import Common.MessageListener;
import Common.MessageSource;
import java.util.ArrayList;

/**
 * Class that handles connections on the Server side
 * @author Ryan Burkhalter
 */
public class BattleServer implements MessageListener{
    
    ServerSocket serverSocket;
    int current;
    Game game;

    /**
     * Initialization of server on construction
     * @param port port to operate the server on
     * @param playerCount desired number of players in the game
     * @throws IOException
     */
    public BattleServer(int port, int playerCount) throws IOException{
        serverSocket = new ServerSocket(port);
        ArrayList<ConnectionAgent> connections = new ArrayList<ConnectionAgent>();
        ServerSocket sock = new ServerSocket(port);
        while (sock.isBound()) {
            Socket subsock = null;
            try {
                subsock = sock.accept();
            } catch (IOException e) {
                System.out.println("An IO error has occurd while attempting to create a connection with a client");
                e.printStackTrace();
            }
            connections.add(new ConnectionAgent(subsock));
        }
    }

    /**
     * listens for incoming messages
     */
    public void listen(){

    }

    /**
     * broadcasts a message to all connected clients
     * @param msg message to broadcast
     */
    public void broadcast(String msg){

    }

    /**
     * handles receipt of a message
     * @param msg message
     * @param src source for message receipt
     */
    public void messageReceived(String msg, MessageSource src){

    }

    /**
     * handles closure of the specified source
     * @param src specified source
     */
    public void sourceClosed(MessageSource src){
        
    }
}
