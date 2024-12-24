package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel {

    private int width = 960;
    private int height = 540;

    String curentText = "";

    public StartPanel(){
        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout());
        setBackground(Color.green);
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        //draw backgrond
        try {
            g.drawImage(ImageIO.read(new File("src/GUI/Afbeeldingen/a1.png")), 0, 0, null);
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
