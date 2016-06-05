package graphics;

import javax.swing.*;
import java.awt.*;

public class Display {
    private int width;
    private int height;
    private String title;

    private JFrame frame;
    private Canvas canvas;

    public Display(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;

        initializeDisplay();
    }

    public Canvas getCanvas(){
        return this.canvas;
    }

    private void initializeDisplay(){
        this.frame = new JFrame(this.title);
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setFocusable(true);

        this.canvas = new Canvas();
        this.canvas.setSize(this.width, this.height);
        this.canvas.setMaximumSize(new Dimension(width, height));
        this.canvas.setMinimumSize(new Dimension(width, height));

        this.frame.add(this.canvas);
        this.frame.pack();
    }
}
