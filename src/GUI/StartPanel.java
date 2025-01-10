package GUI;

import Logic.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartPanel extends JPanel implements KeyListener {

    private DrunkFrame frame;

    private int width;
    private int height;


    String curentText = "";

    public StartPanel(DrunkFrame frame, int width, int height){
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
        new Thread(() -> {
            try {
                // Wacht een paar seconden (bijv. 2 seconden) zodat de GUI volledig laadt
                Thread.sleep(500);

                // Begin met langzaam printen van de tekst
                printTetSlow("press spatie to start");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



    }

    public void printTetSlow(String text){

        for (int i = 0; i < text.length(); i++) {
            curentText = curentText + text.charAt(i);;
            repaint();
            try {
                Thread.sleep(100); // Pauzeer 100 milliseconden
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            frame.SwitchToGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}


    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        //draw backgrond
        try {
            g.drawImage(ImageIO.read(getClass().getResource("/GUI/Afbeeldingen/A1.png")), 0, 0, null);
//            g.drawImage(ImageIO.read(new File("src/GUI/Afbeeldingen/a1.png")), 0, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.setColor(Color.BLACK);
        g.fillRect(0,height/4*3,width,height);
        Font font = new Font("SansSerif", Font.BOLD, 30);
        g.setFont(font);

        FontMetrics metrics = g.getFontMetrics(font);

        int textWidth = metrics.stringWidth(curentText);

        g.setColor(Color.decode("#FFD700"));

        g.drawString(curentText, (getWidth() - textWidth) / 2, height/4*3+40 );


    }
}
