package GameObjects;

import javax.swing.*;
import java.awt.*;

public class ShipLabel extends JLabel {
    private JLabel smallLabel;
    private String shipName;
    private Ship ship;
    private Point headPoint;

    public ShipLabel(JLabel smallLabel, String shipName, Ship ship, Point headPoint) {
        this.smallLabel = smallLabel;
        this.shipName = shipName;
        this.ship = ship;
        this.headPoint = headPoint;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


    }
}
