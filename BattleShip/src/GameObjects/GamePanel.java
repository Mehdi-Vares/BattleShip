package GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.HashSet;

public class GamePanel extends JPanel {
    private Ship[] ships;
    private static JLabel mainLabel;
    private JButton confirmButton, clearButton;
    private static JLabel[] shipLabels;
    protected static Point2D.Double point1 = new Point2D.Double(55, 155);
    protected static Point2D.Double point2 = new Point2D.Double(556, 155);
    protected static int width = 400, height = 310;
    protected static GameBoard myGameBoard, oppGameBoard;
    protected static Shape myOuterPanel, oppOuterPanel;
    protected static Shape myBoard, oppBoard;
    static {
        myOuterPanel = new RoundRectangle2D.Double((int) point1.x, (int) point1.y ,width, height, 50, 50);
        oppOuterPanel = new RoundRectangle2D.Double((int) point2.x, (int) point2.y, width, height, 50, 50);
    }
    public GamePanel() {
        setBackground(Color.black);
        setLayout(null);

        mainLabel = new JLabel();
        myGameBoard = new GameBoard(point1);
        oppGameBoard = new GameBoard(point2);
        this.ships = new Ship[5];

//        // Carrier
//        this.ships[0] = new Ship(5, new Point(myOuterPanel.getBounds().x + 25,
//                myOuterPanel.getBounds().y + 25),
//                false,
//                new Color(0, 255, 255));
//
//        // Battleship
//        this.ships[1] = new Ship(4, new Point(myOuterPanel.getBounds().x + 25,
//                myOuterPanel.getBounds().y + 50), false,
//                new Color(164, 221, 0));
//
//        // Cruiser
//        this.ships[2] = new Ship(3, new Point(myOuterPanel.getBounds().x + 25,
//                myOuterPanel.getBounds().y + 75),
//                false,
//                new Color(219, 77, 226));
//
//        // SubMarine
//        this.ships[3] = new Ship(3, new Point(myOuterPanel.getBounds().x + 25,
//                myOuterPanel.getBounds().y + 100),
//                false,
//                new Color(255, 100, 0));
//
//        // Destroyer
//        this.ships[4] = new Ship(2, new Point(myOuterPanel.getBounds().x + 25,
//                myOuterPanel.getBounds().y + 125),
//                false,
//                new Color(255, 50, 50));


        add(myGameBoard);
        add(oppGameBoard);

        setLabel(
                mainLabel,
                "[  BATTLESHIP  ]",
                25, Color.WHITE,
                new Rectangle(width - ((int) (point2.x - width)) + 10
                        , 20, (int) (point2.x - point1.x), 40));

//        logger = new Log();

    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet())
            return super.getPreferredSize();

        return new Dimension(1000, 700);
    }

    public void drawGamePanel(Graphics2D g) {
        System.out.println("Hello World");
        g.setColor(Color.orange);

        g.fill(myOuterPanel);
        g.fill(oppOuterPanel);

        g.setColor(Color.WHITE);

        myBoard = new RoundRectangle2D.Double(3 * (int) point1.x, (int) point1.y,
                (int) (width - 2 * point1.x), height, 50, 50);
        g.fill(myBoard);
        oppBoard = new RoundRectangle2D.Double((int) point2.x, (int) point2.y,
                (int) (width - 2 * point1.x), height, 50, 50);
        g.fill(oppBoard);

        g.setColor(Color.black);
        for (int i = 0; i < 10; i++) {
            g.setFont(new Font("Italic", Font.PLAIN, 14));
            g.drawString(
                    Integer.toString(i + 1),
                    myGameBoard.getX() - 7 - g.getFontMetrics().stringWidth(Integer.toString(i + 1)),
                    myGameBoard.getY() + 20 + 25 * i
            );

            g.drawString(
                    Integer.toString(i + 1),
                    oppGameBoard.getX() - 7 - g.getFontMetrics().stringWidth(Integer.toString(i + 1)),
                    oppGameBoard.getY() + 20 + 25 * i
            );

            g.drawString(
                    Character.toString((char) (i + 65)),
                    myGameBoard.getX() + 8 + 25 * i,
                    myGameBoard.getY() - 5
            );

            g.drawString(
                    Character.toString((char) (i + 65)),
                    oppGameBoard.getX() + 8 + 25 * i,
                    oppGameBoard.getY() - 5
            );
        }
    }

    public void setButtons(Graphics2D g) {
        Rectangle confirm = new Rectangle(myOuterPanel.getBounds().x + 10, myOuterPanel.getBounds().y,
                50, 25);

        Rectangle clear = new Rectangle(confirm.x + 10, (int) confirm.getY(),
                50, 25);
        confirmButton = new JButton("Confirm");
        clearButton = new JButton("Clear");

        confirmButton.setBounds(confirm);
        confirmButton.setBackground(Color.BLACK);

        clearButton.setBounds(clear);
        clearButton.setBackground(Color.WHITE);

        add(confirmButton);
        add(clearButton);
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        drawGamePanel(g);

        Ship.draw(g, this);
    }

    public void setLabel(JLabel label, String title, int font, Color color, Rectangle r) {
        label.setText(title);
        label.setFont(new Font("Italic", Font.BOLD, font));
        label.setForeground(color);
        label.setBounds(r);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

        add(label);
    }

}