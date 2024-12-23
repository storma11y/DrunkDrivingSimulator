package GUI;

import javax.swing.*;
import java.awt.*;

public class DrunkFrame extends JFrame {

    public DrunkFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("storm");
        setIconImage(new ImageIcon("src/Afbeeldingen/Drunk Driving Simulator icon.png").getImage());
        StartPanel startPanel = new StartPanel();
        setResizable(false);

        add(startPanel);
        pack();
        setLocationRelativeTo(null);
    }
}
