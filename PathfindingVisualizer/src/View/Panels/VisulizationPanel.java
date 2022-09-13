package View.Panels;

import javax.swing.JPanel;

import java.awt.GridLayout;

public class VisulizationPanel extends JPanel {

    final int scalingFactor = 5;
    int WIDTH = 16 * this.scalingFactor;
    int HEIGHT = 9 * this.scalingFactor;

    public VisulizationPanel() {
        this.createVisulizationPanel();
    }

    private void createVisulizationPanel() {
        this.setLayout(new GridLayout(HEIGHT, WIDTH));
        for(int i = 0; i < this.WIDTH; i++) {
            for(int j = 0; j < this.HEIGHT; j++) {
                this.add(new VisualizationNodePanel());
            }   
        }
    }

}
