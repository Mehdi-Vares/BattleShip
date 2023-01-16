package GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ship {
    private Color color;
    private int length;
    private String shipName;
    private ArrayList<ShipPiece> shipPieces = new ArrayList<>();
    private static ArrayList<JLabel> shipLabels = new ArrayList<>();
    private static ArrayList<Ship> ships = new ArrayList<>();
    private boolean isVertical;
    private Point headPointCorner;
    private Point headPoint;
    private boolean isShipDead;
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

    public Ship(String name, int length, Point headPoint, Color color) {
        this.shipName = name;
        this.length = length;
        this.headPoint = headPoint;
        this.color = color;


//        if (isVertical) {
//            Point point = headPoint;
//            for (int i = 0; i < length; i++) {
//                point.y = (int) headPoint.getY() + GameBoard.shipIcon.getIconHeight();
//                this.shipPieces.add(new ShipPiece(point, color, false, GameBoard.shipIcon));
//            }
//
//        } else {
//            Point point = headPoint;
//            for (int i = 0; i < length; i++) {
//                point.x = (int) headPoint.getX() + GameBoard.shipIcon.getIconWidth();
//                this.shipPieces.add(new ShipPiece(point, color, false, GameBoard.shipIcon));
//            }
//            point.y += 50;
//        }

        ships.add(this);
    }

    public void setShipLabel(Graphics2D g, JLabel label) {
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        JLabel smallLabel = new JLabel();

        for (Ship ship : ships) {
            smallLabel.setBackground(ship.color);
            smallLabel.setOpaque(true);
            smallLabel.setBounds(ship.headPoint.x - 20, ship.headPoint.y, 12, 12);


//            ship.setText(ship.shipName);
//            ship.setForeground(Color.WHITE);
//            ship.add(smallLabel);
        }

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
}

