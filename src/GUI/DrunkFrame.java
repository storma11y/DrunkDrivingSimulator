package GUI;

import javax.swing.*;

public class DrunkFrame extends JFrame {

    StartPanel startPanel;

    public int width = 960;
    public int height = 540;

    public DrunkFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Drunk Driving Simulator");
        setIconImage(new ImageIcon("src/GUI/Afbeeldingen/Logo.png").getImage());
        startPanel = new StartPanel(this, width, height);
        setResizable(false);
        add(startPanel);
        pack();
        setLocationRelativeTo(null);
        // music
        Music.PlayBackgrondMusic("src/GUI/Music/spotifydown.com - My Little Pony Theme Song.mp3");
    }

    public void SwitchToGame(){
        remove(startPanel);
        GamePanel gamePanel = new GamePanel(this, width, height);
        add(gamePanel);
        revalidate();
        repaint();
    }
}
