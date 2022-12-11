package Server;

/**
 * Enumeration for all of the types of ships seen in Battleship
 * @author Ryan Burkhalter, Christopher Vines
 */
public enum ShipType {

    CARRIER("C"),

    BATTLESHIP("B"),

    CRUISER("R"),

    SUBMARINE("S"),

    DESTROYER("D");

    public final String shipType;

    private ShipType(String shipType) {
        this.shipType = shipType;
    }
}
