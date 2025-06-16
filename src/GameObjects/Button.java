package GameObjects;

import javax.swing.JButton;
import javax.swing.border.Border;

public class Button extends JButton {
    private int buttonX, buttonY;
    private boolean isOpponent;
    private boolean containsShipPiece = false;
    protected boolean isIconSet;
    protected Border initialBorder;

    public Button(int x, int y, boolean isOpp) {
        this.buttonX = x;
        this.buttonY = y;
        this.isOpponent = isOpp;
        this.initialBorder = getBorder();
    }

    public int getButtonX() {
        return buttonX;
    }

    public int getButtonY() {
        return buttonY;
    }

    public boolean isOpponent() {
        return isOpponent;
    }
}
