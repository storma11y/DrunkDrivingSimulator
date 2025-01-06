package GUI;

import GUI.DrunkFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class EndPanel extends JPanel implements KeyListener {


    private int width;
    private int height;
    private DrunkFrame frame;

    public EndPanel(DrunkFrame frame, int width, int height) {
        this.frame = frame;

        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout());
        setBackground(Color.green);
        // set focus
        setFocusable(true);
        // zorgt dat hij luistert
        addKeyListener(this);
        requestFocus();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        frame.SwitchToStart();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw backgrond
        try {
            g.drawImage(ImageIO.read(new File("src/GUI/Afbeeldingen/a1.png")), 0, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
