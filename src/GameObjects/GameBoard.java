package GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameBoard extends JPanel implements ActionListener, MouseListener {
    private ArrayList<String> choices = new ArrayList<String>(Ship.shipNames.keySet());
    private Button[][] buttons = new Button[10][10];
    private int selectedShips = 0;
    private boolean isOpp;
    protected static ImageIcon icon = new ImageIcon("src/resources/cross_Icon.png");
    protected static ImageIcon redIcon = new ImageIcon("src/resources/redCross.jpg");
    protected static ImageIcon shipIcon = new ImageIcon("src/resources/battleShipIcon.png");

    public GameBoard(Point2D.Double point) {
        Ship.setShips();
        int x, y, height;
        if (point.equals(GamePanel.point1)) {
            x = (int) (3 * GamePanel.point1.x + 30);
            y = (int) (GamePanel.point1.y + 45);
            isOpp = true;

        } else {
            x = (int) GamePanel.point2.x + 30;
            y = (int) GamePanel.point2.y + 45;
            isOpp = false;
        }
        height = GamePanel.height - 60;
        setBounds(x, y, height, height);
        setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new Button(i, j, isOpp);
                buttons[i][j].addActionListener(this);
                buttons[i][j].addMouseListener(this);
                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button button = (Button) e.getSource();

        placeShips(button, true);
        placeShips(button, false);


    }

    public void setButtons(Button button, boolean b){
        if (button.isOpponent()) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    GamePanel.oppGameBoard.buttons[i][j].setEnabled(b);
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    GamePanel.myGameBoard.buttons[i][j].setEnabled(b);
                }
            }
        }
    }

    // direction: vertical -> 0, horizontal -> 1
    public boolean isIconSet(Button button, Ship ship, int direction) {
        try {
            if (direction == 0) {
                for (int i = 0; i < ship.getLength(); i++) {
                    if (buttons[button.getButtonX() + i][button.getButtonY()].isIconSet)
                        return true;
                }

                for (int i = 0; i < ship.getLength(); i++) {
                    buttons[button.getButtonX() + i][button.getButtonY()].setIcon(shipIcon);
                    buttons[button.getButtonX() + i][button.getButtonY()].setBackground(ship.getColor());
                    buttons[button.getButtonX() + i][button.getButtonY()].isIconSet = true;
                }
            } else {
                for (int i = 0; i < ship.getLength(); i++)
                    if (buttons[button.getButtonX()][button.getButtonY() + i].isIconSet)
                        return true;

                for (int i = 0; i < ship.getLength(); i++) {
                    buttons[button.getButtonX()][button.getButtonY() + i].setIcon(shipIcon);
                    buttons[button.getButtonX()][button.getButtonY() + i].setBackground(ship.getColor());
                    buttons[button.getButtonX()][button.getButtonY() + i].isIconSet = true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            button.setIcon(null);
            button.setBackground(null);
            JOptionPane.showMessageDialog(null, "There was a problem with placing this ship, Can't do that!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public void placeShips(Button button, boolean isOpp) {
        while (!choices.isEmpty()) {
            if (!button.isIconSet) {
                setButtons(button, !isOpp);

                String input = (String) JOptionPane.showInputDialog(null,
                        "choose which ship you want to place here... ", "ship positioning",
                        JOptionPane.QUESTION_MESSAGE, null, choices.toArray(), choices);

                int direction = JOptionPane.showConfirmDialog(null, "Should " + input + " be vertical ?",
                        "Direction", JOptionPane.YES_NO_OPTION);

                Ship ship = Ship.getShipByName(input);
                if (isIconSet(button, ship, direction)) {
                    JOptionPane.showMessageDialog(null, "Some buttons already contain ship pieces !!",
                            "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    choices.remove(input);
                }
            } else {
                JOptionPane.showMessageDialog(null, "This button already contains ship piece !!",
                        "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Button button = (Button) e.getComponent();
        button.setBorder(BorderFactory.createLineBorder(Color.RED, 3, true));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Button button = (Button) e.getComponent();
        button.setBorder(button.initialBorder);
    }
}
