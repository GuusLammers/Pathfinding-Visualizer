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

    Color startNodeColor = Color.green;
    Color endNodeColor = Color.red;
    Color wallNodeColor = Color.black;

    VisualizationNodePanel[][] nodes;

    boolean isMouseDown = false;
    boolean movingStartNode = false;
    boolean movingEndNode = false;

    PanelListener panelListener;

    public VisulizationPanel() {
        this.setBackground(Color.white);
        this.nodes = new VisualizationNodePanel[this.HEIGHT][this.WIDTH];
        this.panelListener = new PanelListener();
        this.createVisulizationPanel();
        this.randomlyPlaceStartAndEndNodes();
    }

    private void createVisulizationPanel() {
        this.setLayout(new GridLayout(HEIGHT, WIDTH));
        for(int i = 0; i < this.WIDTH; i++) {
            for(int j = 0; j < this.HEIGHT; j++) {
                VisualizationNodePanel node = new VisualizationNodePanel();
                node.addMouseListener(panelListener);
                this.nodes[j][i] = node;
                this.add(node);
            }   
        }
    }

    private void randomlyPlaceStartAndEndNodes() {
        int startRow = getRandomNumber(0, this.HEIGHT);
        int startCol = getRandomNumber(0, this.WIDTH);
        int endRow = getRandomNumber(0, this.HEIGHT);
        int endCol = getRandomNumber(0, this.WIDTH);

        this.nodes[startRow][startCol].setStart();
        this.nodes[endRow][endCol].setEnd();
    }

    private class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {}

        @Override
        public void mouseEntered(MouseEvent event) {
            /*
             * Triggered when the mouse enters a node panel
             */
            if(isMouseDown) {
                Object source = event.getSource();
                if(source instanceof VisualizationNodePanel){
                    VisualizationNodePanel panelPressed = (VisualizationNodePanel) source;
                    if(movingStartNode) {
                        panelPressed.setStart();
                    }
                    else if(movingEndNode) {
                        panelPressed.setEnd();
                    } 
                    else {
                        panelPressed.setWall();
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent event) {
            if(isMouseDown) {
                Object source = event.getSource();
                if(source instanceof VisualizationNodePanel){
                    VisualizationNodePanel panelPressed = (VisualizationNodePanel) source;
                    if(movingStartNode || movingEndNode) {
                        panelPressed.setEmpty();
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent event) {
            /*
             * Triggered when mouse is pressed down.
             */
            isMouseDown = true;
            Object source = event.getSource();
            if(source instanceof VisualizationNodePanel){
                VisualizationNodePanel panelPressed = (VisualizationNodePanel) source;
                if(panelPressed.isStartNode()) {
                    movingStartNode = true;
                }
                else if(panelPressed.isEndNode()) {
                    movingEndNode = true;
                }
                else {
                    panelPressed.setWall();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            /*
             * Triggered when mouse is released.
             */
            isMouseDown = false;
            movingStartNode = false;
            movingEndNode = false;
        }

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
