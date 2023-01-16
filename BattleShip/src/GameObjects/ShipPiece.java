package GameObjects;

import javax.swing.ImageIcon;
import java.awt.*;

public class ShipPiece {
    private Point poistion;
    private Color color;
    private boolean isDestroyed;
    private ImageIcon icon;

    public ShipPiece(Point poistion, Color color, boolean isDead, ImageIcon icon) {
        this.poistion = poistion;
        this.color = color;
        this.isDestroyed = isDead;
        this.icon = icon;
    }

    public Point getPoistion() {
        return poistion;
    }

    public Color getColor() {
        return color;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
