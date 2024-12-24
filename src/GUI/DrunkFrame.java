package GUI;

import javax.swing.*;

public class DrunkFrame extends JFrame {

    public DrunkFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Drunk Driving Simulator");
        setIconImage(new ImageIcon("src/GUI/Afbeeldingen/Logo.png").getImage());
        StartPanel startPanel = new StartPanel();
        setResizable(false);
        add(startPanel);
        pack();
        setLocationRelativeTo(null);
        // music
        Music.PlayBackgrondMusic("src/GUI/Music/spotifydown.com - My Little Pony Theme Song.mp3");
    }
}
