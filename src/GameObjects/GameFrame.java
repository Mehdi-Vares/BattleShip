package GameObjects;

import javax.swing.*;

public class GameFrame extends JFrame {
    private GamePanel panel;
    public GameFrame() {
        panel = new GamePanel();
    }

    public void createAndShowGUI() {
        setUndecorated(true);
        setIconImage(new ImageIcon("src/resources/battleship.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public GamePanel getPanel() {
        return panel;
    }
}
