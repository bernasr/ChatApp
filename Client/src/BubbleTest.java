import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class BubbleTest {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        LeftArrowBubble leftArrowBubble = new LeftArrowBubble();
        JOptionPane.showMessageDialog(null, leftArrowBubble);
        RightArrowBubble rightArrowBubble = new RightArrowBubble();
        JOptionPane.showMessageDialog(null, rightArrowBubble);
    }

    private static class LeftArrowBubble extends JPanel {

        private int strokeThickness = 5;
        private int padding = strokeThickness / 2;
        private int radius = 10;
        private int arrowSize = 6;

        @Override
        protected void paintComponent(final Graphics g) {
            final Graphics2D graphics2D = (Graphics2D) g;
            RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics2D.setRenderingHints(qualityHints);
            graphics2D.setColor(new Color(80, 150, 180));
            graphics2D.setStroke(new BasicStroke(strokeThickness));
            int x = padding + strokeThickness + arrowSize;
            int width = getWidth() - arrowSize - (strokeThickness * 2);
            int height = getHeight() - strokeThickness;
            graphics2D.fillRect(x, padding, width, height);
            RoundRectangle2D.Double rect = new RoundRectangle2D.Double(x, padding, width, height, radius, radius);
            Polygon arrow = new Polygon();
            arrow.addPoint(14, 6);
            arrow.addPoint(arrowSize + 2, 10);
            arrow.addPoint(14, 12);
            Area area = new Area(rect);
            area.add(new Area(arrow));
            graphics2D.draw(area);
            graphics2D.dispose();
        }

    }

    private static class RightArrowBubble extends JPanel {

        private int strokeThickness = 5;
        private int padding = strokeThickness / 2;
        private int arrowSize = 6;
        private int radius = 10;

        @Override
        protected void paintComponent(final Graphics g) {
            final Graphics2D graphics2D = (Graphics2D) g;
            RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics2D.setRenderingHints(qualityHints);
            graphics2D.setColor(new Color(20, 130, 230));
            graphics2D.setStroke(new BasicStroke(strokeThickness));
            int width = getWidth() - arrowSize - (strokeThickness * 2);
            int height = getHeight() - strokeThickness;
            graphics2D.fillRect(padding, padding, width, height);
            RoundRectangle2D.Double rect = new RoundRectangle2D.Double(padding, padding, width, height, radius, radius);
            Polygon arrow = new Polygon();
            arrow.addPoint(width, 6);
            arrow.addPoint(width + arrowSize, 10);
            arrow.addPoint(width, 12);
            Area area = new Area(rect);
            area.add(new Area(arrow));
            graphics2D.draw(area);
            graphics2D.dispose();
        }

    }

}
