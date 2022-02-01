package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelHangman extends JPanel {
    public static final int WIDTH = 250;
    public static final int HEIGHT = 250;
    private int step;

    public PanelHangman(){
        step=0;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    public void drawBody(int step){
        this.step=step;
        repaint();
    }

    public void reset(){
        step=0;
        repaint();
    }
}
