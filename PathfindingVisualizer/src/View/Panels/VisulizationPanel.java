package View.Panels;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class VisulizationPanel extends JPanel {

    final int scalingFactor = 5;
    int WIDTH = 16 * this.scalingFactor;
    int HEIGHT = 9 * this.scalingFactor;

    boolean isMouseDown = false;

    PanelListener panelListener;

    public VisulizationPanel() {
        this.setBackground(Color.white);
        this.panelListener = new PanelListener();
        this.createVisulizationPanel();
    }

    private void createVisulizationPanel() {
        this.setLayout(new GridLayout(HEIGHT, WIDTH));
        for(int i = 0; i < this.WIDTH; i++) {
            for(int j = 0; j < this.HEIGHT; j++) {
                VisualizationNodePanel node = new VisualizationNodePanel();
                node.addMouseListener(panelListener);
                this.add(node);
            }   
        }
    }

    private class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {}

        @Override
        public void mouseEntered(MouseEvent event) {
            /*
             * Triggered when the mouse enters a node panel
             */
            System.out.println("Entered");
            if(isMouseDown) {
                Object source = event.getSource();
                if(source instanceof JPanel){
                    JPanel panelPressed = (JPanel) source;
                    panelPressed.setBackground(Color.black);
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent event) {}

        @Override
        public void mousePressed(MouseEvent event) {
            /*
             * Triggered when mouse is pressed down.
             */
            isMouseDown = true;
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            /*
             * Triggered when mouse is released.
             */
            isMouseDown = false;
        }

    }

}
