package View.Panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.GridLayout;

public class NavigationPanel extends JPanel {
    
    JButton startButton;
    JButton clearButton;
    JButton resetButton;

    JComboBox<String> algorithmSelector;

    public NavigationPanel() {
        this.setLayout(new GridLayout());

        this.startButton = new JButton("Start");
        this.clearButton = new JButton("Clear");
        this.resetButton = new JButton("Reset");

        this.algorithmSelector = new JComboBox<String>();
        this.algorithmSelector.addItem("Dijkstra's");
        this.algorithmSelector.addItem("A*");

        this.add(startButton);
        this.add(algorithmSelector);
        this.add(clearButton);
        this.add(resetButton);
    }

}
