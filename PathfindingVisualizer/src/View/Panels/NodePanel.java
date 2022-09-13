package View.Panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;

public class NodePanel extends JPanel{

    boolean isStartNode = false;
    boolean isEndNode = false;
    boolean isWallNode = false;
    
    public NodePanel() {
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    }

    public void setEmpty() {
        this.isStartNode = false;
        this.isEndNode = false;
        this.isWallNode = false;
        this.setBackground(Color.lightGray);
    }

    public void setStart() {
        this.isStartNode = true;
        this.isEndNode = false;
        this.isWallNode = false;
        this.setBackground(Color.green);
    }

    public void setEnd() {
        this.isStartNode = false;
        this.isEndNode = true;
        this.isWallNode = false;
        this.setBackground(Color.red);
    }

    public void setWall() {
        this.isStartNode = false;
        this.isEndNode = false;
        this.isWallNode = true;
        this.setBackground(Color.black);
    }

    public boolean isStartNode() {
        return this.isStartNode;
    }

    public boolean isEndNode() {
        return this.isEndNode;
    }

    public boolean isWallNode() {
        return this.isWallNode;
    }

}
