package TestMouseMotion;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
    private DragPanel dragPanel = new DragPanel();
    public MyFrame() {
        this.setTitle("Drag & Drop demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(dragPanel);
        this.pack();
        this.setVisible(true);
    }
}
