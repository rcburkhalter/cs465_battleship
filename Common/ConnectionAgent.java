package Common;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionAgent implements Runnable {
    
    Socket socket;

    Scanner in;

    PrintStream out;

    Thread thread;


    public ConnectionAgent(Socket socket){
        this.socket = socket;
    }

    public void sendMessage(String message){

    }

    public boolean isConnected(){

        return Thread.interrupted();
    }

    public void close(){}

    public void run(){

        thread = Thread.currentThread();
        
    }


}
