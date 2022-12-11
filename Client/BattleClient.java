package Client;
import Common.MessageSource;
import Common.MessageListener;

/**
 * This class acts as a manager for all of the client data
 * @author Ryan Burkhalter
 */
public class BattleClient extends MessageSource implements MessageListener {
    /**
     * This method handles closure of the specified source
     */
    public void sourceClosed(MessageSource source) {

    }

    /**
     * This method handles message receipt
     */
    public void messageReceived(String Message, MessageSource Source) {

    }
    
}
