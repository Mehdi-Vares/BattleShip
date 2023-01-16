package GameObjects;

import GameObjects.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ship extends JLabel {
    private int length;
    private static JPanel panel = new JPanel();
    private ArrayList<ShipPiece> shipPieces = new ArrayList<>();
    private static ArrayList<JLabel> shipLabels = new ArrayList<>();
    private static ArrayList<Ship> ships = new ArrayList<>();
    private boolean isVertical;
    private Point headPointCorner;
    private Point headPoint;
    private boolean isShipDead;
    private JLabel label;
    protected static int drownedShipsCount = 0;
    protected volatile static boolean isGameFinished;
    private static Map<String, Integer> shipNames = new HashMap<>();
    static {
        shipNames.put("Carrier", 5);
        shipNames.put("BattleShip", 4);
        shipNames.put("Cruiser", 3);
        shipNames.put("Submarine", 3);
        shipNames.put("Destroyer", 2);
    }

    public Ship(int length, Point headPoint, boolean isVertical, Color color) {
        this.length = length;
        this.headPoint = headPoint;
        this.isVertical = isVertical;

        if (isVertical) {
            Point point = headPoint;
            for (int i = 0; i < length; i++) {
                point.y = (int) headPoint.getY() + GameBoard.shipIcon.getIconHeight();
                this.shipPieces.add(new ShipPiece(point, color, false, GameBoard.shipIcon));
            }

        } else {
            Point point = headPoint;
            for (int i = 0; i < length; i++) {
                point.x = (int) headPoint.getX() + GameBoard.shipIcon.getIconWidth();
                this.shipPieces.add(new ShipPiece(point, color, false, GameBoard.shipIcon));
            }
            point.y += 50;
        }

        ships.add(this);
    }

    public static void draw(Graphics2D g, JPanel p) {
        for (Ship ship : ships) {
            for (ShipPiece shipPiece : ship.shipPieces) {
                shipPiece.getIcon().paintIcon(p, g, shipPiece.getPoistion().x, shipPiece.getPoistion().y);
            }
        }
    }

    public void setVertical(boolean vertical) {

    }

    public static void setShips(ArrayList<Ship> ships) {

    }
}

