package Server;

/**
 * A ship that is placed on the board
 * @author Ryan Burkhalter, Christopher Vines
 */
public class Ship {
    /* size of ship to set its type */
    private int shipSize;

    /* Type of the ship */
    ShipType type;

    /**
     * Creates ship with given parameters
     * @param size size of ship
     * @param type type of ship
     */
    public Ship(int size, ShipType type) {
        this.shipSize = size;

        this.type = type;
    }

    /**
     * returns type of ship
     * @return ship type
     */
    public ShipType getShipType() {
        return this.type;
    }

    /**
     * returns size of ship
     * @return ship size
     */
    public int getShipSize() {
        return this.shipSize;
    }

}
