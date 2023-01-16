package GameObjects;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        
    }

    public void createAndShowGUI() {
        setUndecorated(true);
        setIconImage(new ImageIcon("src/resources/battleship.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
