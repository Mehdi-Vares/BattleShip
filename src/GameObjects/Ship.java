package GameObjects;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ship {
    private Color color;
    private int length;
    private String shipName;
    private static boolean isPlaced;
    private static List<Ship> ships = new ArrayList<>();
    private boolean isVertical;
    private Point headPoint;
    private boolean isShipDead;
    protected static int drownedShipsCount = 0;
    protected volatile static boolean isGameFinished;
    protected static Map<String, Integer> shipNames = new HashMap<>();
    static {
        shipNames.put("Carrier", 5);
        shipNames.put("Battleship", 4);
        shipNames.put("Cruiser", 3);
        shipNames.put("Submarine", 3);
        shipNames.put("Destroyer", 2);
    }

    public Ship() {
    }

    public Ship(String shipName, int length, Color color) {
        this.shipName = shipName;
        this.length = length;
        this.color = color;
    }

    public static void setShips() {
        // Carrier
        ships.add(new Ship("Carrier", 5, new Color(164, 221, 0)));

        // Battleship
        ships.add(new Ship("Battleship", 4, new Color(0, 255, 255)));

        // Cruiser
        ships.add(new Ship("Cruiser", 3,  new Color(219, 77, 226)));

        // SubMarine
        ships.add(new Ship("Submarine", 3, new Color(255, 100, 0)));

        // Destroyer
        ships.add(new Ship("Destroyer", 2, new Color(255, 50, 50)));
    }

    public String getShipName() {
        return shipName;
    }

    public int getLength() {
        return length;
    }

    public Color getColor() {
        return color;
    }

    public static boolean isPlaced() {
        return isPlaced;
    }

    public static List<Ship> getShips() {
        return ships;
    }
    public static Ship getShipByName(String shipName) {
        return Ship.getShips().stream().filter(x -> x.shipName.equals(shipName)).toList().get(0);
    }

    public void setVertical(boolean vertical) {

    }
}

