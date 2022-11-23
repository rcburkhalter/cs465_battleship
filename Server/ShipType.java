package Server;

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
