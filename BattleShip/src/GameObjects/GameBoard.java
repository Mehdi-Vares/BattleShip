package GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class GameBoard extends JPanel implements ActionListener, MouseListener {
    private Button[][] buttons = new Button[10][10];
    private boolean isOpp;
    protected static ImageIcon icon = new ImageIcon("src/resources/cross_Icon.png");
    protected static ImageIcon redIcon = new ImageIcon("src/resources/redCross.jpg");
    protected static ImageIcon shipIcon = new ImageIcon("src/resources/battleShipIcon.png");

    public GameBoard(Point2D.Double point) {
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

        setLayout(new GridLayout(10, 10));
        setBounds(x, y,height, height);
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

        if (button.isIconSet) {
            button.setIcon(shipIcon);


        } else {
            button.setIcon(icon);
            button.isIconSet = true;
        }

    }
    public static void placeShips() {
        ImageIcon Qustionicon = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\BattleShip\\src\\qst.png");


        String[] choices = { "submarine(3) position : verticverticall",
                "submarine(3) position : horizental",
                "cruiser(3) position : vertical","cruiser(3) position : horizental" ,
                "carrier(4) position : vertical","carrier(4) position : horizental",
                "battleship(5) position : vertical",
                "battleship(5) position : horizental" };

        String input = (String) JOptionPane.showInputDialog(null,
                "choos which ship u want to place here ","ship positioning",
                JOptionPane.QUESTION_MESSAGE,Qustionicon,choices, choices);


    }

    public void setButtonsDisabled(Button button) {
        if (button.isOpponent()) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    GamePanel.myGameBoard.buttons[i][j].setEnabled(false);
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    GamePanel.oppGameBoard.buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    public Button[][] getButtons() {
        return buttons;
    }

    public static ImageIcon getIcon() {
        return icon;
    }

    public static ImageIcon getRedIcon() {
        return redIcon;
    }

    public static ImageIcon getShipIcon() {
        return shipIcon;
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