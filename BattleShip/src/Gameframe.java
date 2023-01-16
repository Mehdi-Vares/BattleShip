import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gameframe extends JFrame implements ActionListener{
    public JButton[][] buttons;
    public JButton[][] buttons1;
    private JButton confirm;
    private JTextField Texfield;
    private ImageIcon crossIcon = new ImageIcon("src/resources/cross.jpg");
    public int start() {
        int init = JOptionPane.showConfirmDialog(null, "are you the host", "hosting", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        return init;
    }

    public String gettingip() throws Exception {
        this.setLayout(new FlowLayout());
        Texfield = new JTextField();
        Texfield.setPreferredSize(new Dimension(250,40));
        confirm = new JButton("confirm");
        confirm.addActionListener(this);
        this.add(confirm);
        this.add(Texfield);
        this.pack();
        this.setVisible(true);
        return Texfield.getText();
    }
    public Gameframe() {

    }

    public void creatframe(){
        JPanel basepanel = new JPanel();
        basepanel.setBackground(new Color(0,0,0));
        basepanel.setBounds(30,30,1540,810);

        JPanel firstpanel = new JPanel();
        firstpanel.setBackground(new Color(130,96,62));
        firstpanel.setBounds(770,60,770,750);

        JPanel secondpanel = new JPanel();
        secondpanel.setBackground(new Color(130,96,62));
        secondpanel.setBounds(60,60,770,750);

        buttons = new JButton[10][10];
        buttons1 = new JButton[10][10];


        //this is for choosing battle ships
 //       ImageIcon Qustionicon = new ImageIcon("1461855.png");
 //       String[] choices = { "submarine(3) position : | ","submarine(3) position : - ", "cruiser(3) position : | ","cruiser(3) position : - " , "carrier(4) position : |","carrier(4) position : - ", "battleship(5) position : | ", "battleship(5) position : - " };
 //       String input = (String) JOptionPane.showInputDialog(null, "choos which ship u want to place here ","ship positioning", JOptionPane.QUESTION_MESSAGE, Qustionicon,choices,choices[1]);
 //       System.out.println(input);

        setButtons();
        ImageIcon icon = new ImageIcon("battleship.iml");
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setSize(1600,900);
        this.setTitle("the battle ship game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(164, 230, 0));
        this.add(secondpanel);
        this.add(firstpanel);
        this.add(basepanel);
        this.setVisible(true);

    }

    public void waiting() {
            JOptionPane.showMessageDialog(null, "waiting for other player", "waiting", JOptionPane.INFORMATION_MESSAGE);
    }
    public void setButtons() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBounds(100+(i*61),70+(j*73), 60, 72);
                this.add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons1[i][j] = new JButton();
                buttons1[i][j].setBounds(840+(i*61),70+(j*73), 60, 72);
                this.add(buttons1[i][j]);
                buttons1[i][j].addActionListener(this);
            }
        }
    }

    public void setButtonsFalse(boolean isHost) {
        if (isHost) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    buttons1[i][j].setEnabled(false);
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setIcon(crossIcon);

        JButton button1 = (JButton) e.getSource();
        button1.setIcon(crossIcon);

        if (e.getSource() == confirm){
            Texfield.getText();
        }

    }
}
