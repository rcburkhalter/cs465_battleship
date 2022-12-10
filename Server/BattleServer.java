package Server;

import java.io.IOException;
import java.net.ServerSocket;

import Common.MessageSource;

public class BattleServer {
    
    ServerSocket serverSocket;

    int current;

    Game game;

    public BattleServer(int port) throws IOException{

        serverSocket = new ServerSocket(port);
    }

    public void listen(){

    }

    public void broadcast(String msg){

    }

    public void messageReceived(String msg, MessageSource src){

    }

    public void sourceClosed(MessageSource src){
        
    }
}
