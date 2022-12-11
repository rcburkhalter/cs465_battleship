package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
/**
 * The connection agent handles the connections between client and server
 * @author Ryan Burkhalter, Christopher Vines
 */
public class ConnectionAgent extends MessageSource implements Runnable {
    
    Socket socket;
    Scanner in;
    PrintStream out;
    Thread thread;

    /**
     * Constructor given a socket
     * @param socket socket given to connection agent for initialization
     */
    public ConnectionAgent(Socket socket){
        this.socket = socket;

    }

    /**
     * Sends a message to the opposing connected ConnectionAgent
     * @param message message to send
     */
    public void sendMessage(String message){
    }

    /**
     * Returns the connection status 
     * @return
     */
    public boolean isConnected(){

        return Thread.interrupted();
    }

    /**
     * Closes the connection
     */
    public void close(){}

    /**
     * handles the continuous operation of the agent
     */
    public void run(){
        BufferedReader inreader = null;
        OutputStreamWriter outwriter = null;
        try {
            inreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outwriter = new OutputStreamWriter(socket.getOutputStream());   
        } catch (IOException e) {
            System.out.println("An IO exception has occured");
            e.printStackTrace();
        }
        while (!socket.isClosed()) {
            try {
                String line = inreader.readLine();
                
            } catch (IOException e) {
                System.out.println("An IO error has occured while attempting to read data");
                e.printStackTrace();
                return;
            }
        }
    }


}
