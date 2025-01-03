package GUI;

import Logic.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements KeyListener {

    private int width;
    private int height;

    private Game game;

    private DrunkFrame frame;

    public GamePanel(DrunkFrame frame, int width, int height){
        this.frame = frame;

        this.width = width;
        this.height = height;

        game = new Game();
        setPreferredSize(new Dimension(100, 100));
        setLayout(new FlowLayout());
        setBackground(Color.green);
        // set focus
        setFocusable(true);
        requestFocusInWindow();
        // zorgt dat hij luistert
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        game.SetInpute(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {}

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
