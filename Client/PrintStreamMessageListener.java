package Client;

import Common.MessageListener;
import Common.MessageSource;

/**
 * An observer class that also writes out
 * @author Ryan Burkhalter
 */
public class PrintStreamMessageListener implements MessageListener{

    /**
     * Receives messages and writes out
     */
    public void messageReceived(String message, MessageSource source) {

    }
    /**
     * Deals with closure of the specified source
     */
    public void sourceClosed(MessageSource source) {
        
    }
}