package Server;

public class Ship {
    /* size of ship to set its type */
    private int shipSize;

    /* Type of the ship */
    ShipType type;

    public Ship(int size, ShipType type) {
        this.shipSize = size;

        this.type = type;
    }

    public ShipType getShipType() {
        return this.type;
    }

}
