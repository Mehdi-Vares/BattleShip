package GameObjects;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    private JButton confirmButton, clearButton;

    public Log() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRoundRect(0, (int) GamePanel.point1.y + GamePanel.height + 50, 1000,
                (int) GamePanel.point1.y, 50, 50);

    }



}
