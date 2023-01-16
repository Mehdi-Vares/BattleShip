import java.awt.*;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RectangularGradientTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new RectangularGradientTestPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


    class RectangularGradientTestPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics gr) {
            super.paintComponent(gr);
            Graphics2D g = (Graphics2D)gr;

            RoundRectangle2D r = new RoundRectangle2D.Double(100,100,200,100, 50, 50);
            drawGradientBorder(g, r, 50);

            Shape rr = new RoundRectangle2D.Double(80,80,240,140,20,20);
            g.setColor(Color.BLACK);
            g.fill(rr);

        }

        @Override
        public Dimension getPreferredSize() {
            if (isPreferredSizeSet()) {
                return super.getPreferredSize();
            }
            return new Dimension(400,300);
        }

        public static void drawGradientBorder(Graphics2D g, RoundRectangle2D r, double s) {
            Color c0 = Color.ORANGE;
            Color c1 = new Color(255, 200, 0, 0);

            double x0 = r.getMinX();
            double y0 = r.getMinY();
            double x1 = r.getMaxX();
            double y1 = r.getMaxY();
            double w = r.getWidth();
            double h = r.getHeight();

            // Left
            g.setPaint(new GradientPaint(
                    new Point2D.Double(x0, y0), c0,
                    new Point2D.Double(x0 - s, y0), c1));
            g.fill(new Rectangle2D.Double(x0 - s, y0, s, h));

            // Right
            g.setPaint(new GradientPaint(
                    new Point2D.Double(x1, y0), c0,
                    new Point2D.Double(x1 + s, y0), c1));
            g.fill(new Rectangle2D.Double(x1, y0, s, h));

            // Top
            g.setPaint(new GradientPaint(
                    new Point2D.Double(x0, y0), c0,
                    new Point2D.Double(x0, y0 - s), c1));
            g.fill(new Rectangle2D.Double(x0, y0 - s, w, s));

            // Bottom
            g.setPaint(new GradientPaint(
                    new Point2D.Double(x0, y1), c0,
                    new Point2D.Double(x0, y1 + s), c1));
            g.fill(new Rectangle2D.Double(x0, y1, w, s));

            float fractions[] = new float[] { 0.0f, 1.0f };
            Color colors[] = new Color[] { c0, c1 };

            // Top Left
            g.setPaint(new RadialGradientPaint(
                    new Rectangle2D.Double(x0 - s, y0 - s, s + s, s + s),
                    fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE));
            g.fill(new Rectangle2D.Double(x0 - s, y0 - s, s, s));

            // Top Right
            g.setPaint(new RadialGradientPaint(
                    new Rectangle2D.Double(x1 - s, y0 - s, s + s, s + s),
                    fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE));
            g.fill(new Rectangle2D.Double(x1, y0 - s, s, s));

            // Bottom Left
            g.setPaint(new RadialGradientPaint(
                    new Rectangle2D.Double(x0 - s, y1 - s, s + s, s + s),
                    fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE));
            g.fill(new Rectangle2D.Double(x0 - s, y1, s, s));

            // Bottom Right
            g.setPaint(new RadialGradientPaint(
                    new Rectangle2D.Double(x1 - s, y1 - s, s + s, s + s),
                    fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE));
            g.fill(new Rectangle2D.Double(x1, y1, s, s));
        }


    }