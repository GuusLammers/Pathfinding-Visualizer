import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class View extends JFrame {
    
    public View() {

        this.setTitle("Pathfinding Visualizer"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(true);

        this.makeFullScreen();

    }

    private void makeFullScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
    }

}
