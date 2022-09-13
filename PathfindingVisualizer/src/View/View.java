package View;

import javax.swing.JFrame;

import View.Panels.NavigationPanel;
import View.Panels.VisulizationPanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;

public class View extends JFrame {
    
    NavigationPanel navigationPanel;
    VisulizationPanel visualizationPanel;

    public View() {
        this.setTitle("Pathfinding Visualizer"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(true);

        navigationPanel = new NavigationPanel();
        visualizationPanel = new VisulizationPanel();
        this.add(navigationPanel, BorderLayout.NORTH);
        this.add(visualizationPanel, BorderLayout.CENTER);
        this.pack();

        this.makeFullScreen();
    }

    private void makeFullScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
    }

}
