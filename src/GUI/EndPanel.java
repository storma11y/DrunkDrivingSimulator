package GUI;

import GUI.DrunkFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EndPanel extends JPanel implements KeyListener {


    private int width;
    private int height;
    private DrunkFrame frame;
    private double promiel;

    public EndPanel(DrunkFrame frame, int width, int height, int score) {
        this.frame = frame;

        this.width = width;
        this.height = height;

        this.promiel = frame.BerekenPromiel(score);

        setPreferredSize(new Dimension(width, height));
        setLayout(new FlowLayout());
        setBackground(Color.green);
        // set focus
        setFocusable(true);
        // zorgt dat hij luistert
        addKeyListener(this);
        requestFocus();
    }

    private int GetHyscore(){
        File file = new File("src/Logic/Hyscore.txt");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int hyscore = 0;
            while ((line = reader.readLine()) != null){
                int score = Integer.parseInt(line);
                if (score > hyscore){
                    hyscore = score;
                }
            }
            return hyscore;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
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
            g.drawImage(ImageIO.read(getClass().getResource("/GUI/Afbeeldingen/end.png")), 0, 0, null);
//            g.drawImage(ImageIO.read(new File("src/GUI/Afbeeldingen/end.png")), 0, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        g.setColor(Color.black);

        g.fillRect(width/10*6, height/10, width/20*7, height/10*8);

        Font font = new Font("SansSerif", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.decode("#FFD700"));

        g.drawString("Jouw Promille:", width/100*67, height/3-50 );
        g.drawString(String.valueOf(promiel)+"‰", width/100*67, height/3 );
        g.drawString("Hoogste Promille:", width/100*67, height/3+50 );
        g.drawString(String.valueOf(frame.BerekenPromiel(GetHyscore()))+"‰", width/100*67, height/3+100 );





    }

}
