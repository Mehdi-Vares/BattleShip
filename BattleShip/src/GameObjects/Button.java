package GameObjects;

import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.event.MouseEvent;

public class Button extends JButton {
    private int x, y;
    private boolean isOpponent;
    private boolean containsShipPiece = false;
    protected boolean isIconSet;
    protected Border initialBorder;
    public Button(int x, int y, boolean isOpp) {
        this.x = x;
        this.y = y;
        this.isOpponent = isOpp;
        this.initialBorder = getBorder();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public boolean isOpponent() {
        return isOpponent;
    }
}
