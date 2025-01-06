package GUI;

import javax.swing.*;
import java.awt.*;

public class DrunkFrame extends JFrame {

    public int width = 960;
    public int height = 540;

    public DrunkFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Drunk Driving Simulator");
        setIconImage(new ImageIcon("src/GUI/Afbeeldingen/Logo.png").getImage());
        StartPanel startPanel = new StartPanel(this, width, height);
        setResizable(false);
        add(startPanel);
        pack();
        setLocationRelativeTo(null);
        // music
        Music.PlayBackgrondMusic("src/GUI/Music/spotifydown.com - My Little Pony Theme Song.mp3");
    }

    public void SwitchToGame(){
        getContentPane().removeAll();
        GamePanel gamePanel = new GamePanel(this, width, height);
        add(gamePanel);
        revalidate();
        repaint();
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());
    }
    public void SwitchToEnd(){
        getContentPane().removeAll();
        EndPanel endPanel = new EndPanel(this, width, height);
        add(endPanel);
        revalidate();
        repaint();
        SwingUtilities.invokeLater(() -> endPanel.requestFocusInWindow());
    }

    public void SwitchToStart(){
        getContentPane().removeAll();
        StartPanel startPanel = new StartPanel(this, width, height);
        add(startPanel);
        revalidate();
        repaint();
        SwingUtilities.invokeLater(() -> startPanel.requestFocusInWindow());
    }
}
