package GUI;

import Logic.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // Controleer of de Shift-toets ingedrukt is

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            return;
        }
        char keyChar = e.getKeyChar();
        System.out.println(keyChar);

        System.out.println(keyChar);
        if (game.SetInpute(keyChar)){
            frame.SwitchToEnd();
        }
        repaint();

    }
    private boolean isFalit(char c) {
        String specialChars = "`~!@#$%^&*()_+1234567890-=qwertyuiopasdfghjklzxcvbnm{[]}|";
        return specialChars.indexOf(c) != -1;
    }


    @Override
    public void keyReleased(KeyEvent e) {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random rand = new Random();
        int n = rand.nextInt(2);
        Font font = new Font("SansSerif", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.decode("#FFD700"));
        //draw backgrond
        if (n == 0){
            //links is nu goed
            try {
                g.drawImage(ImageIO.read(new File("src/GUI/Afbeeldingen/A2.png")), 0, 0, null);

                g.drawString(String.valueOf(game.goodChar), width/4, height/2 );
                g.drawString(String.valueOf(game.foeiChar), width/4*3, height/2 );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                g.drawImage(ImageIO.read(new File("src/GUI/Afbeeldingen/A3.png")), 0, 0, null);
                g.drawString(String.valueOf(game.goodChar), width/4*3, height/2 );
                g.drawString(String.valueOf(game.foeiChar), width/4, height/2 );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


//        g.fillRect(0,0,1000,1000);
    }
}
