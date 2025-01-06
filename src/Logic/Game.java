package Logic;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Random;

public class Game {
    private int difficulty = 0;

    public char goodChar = ' ';
    public char foeiChar = ' ';

    public int score = 0;

    public Game() {
        Scrembel();
    }

    private void Scrembel(){
        goodChar = GetRandomChar();
        while (goodChar == foeiChar || foeiChar == ' '){
            foeiChar = GetRandomChar();
        }
    }

    private void EndGame(){

        File file = new File("src/Logic/Hyscore.txt");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(String.valueOf(score));
            writer.newLine();

            writer.close();

        } catch (Exception e){

        }

    }

    private char GetRandomChar(){
        Random rand = new Random();
        int n = rand.nextInt(15);
        char[] optiesCase0 = {'a', 'd', 's', 'w', 'r', 'f', 'd', 'z', 'x', 'e', 'i', 'k', 'l', 'm', 'h'};
        char[] optiesCase1 = {'A', 'B', 'D', 'W', 'j', 'o', '0', 'O', '9', 'k', 'K', 'L', 'I', 'i', 'z'};
        char[] optiesCase2 = {'l', 'I', '|', '*', 'J', '(', '*', 'G', '&', '%', '^', 'J', 'K', '}', '{'};

        switch (difficulty) {
            case 0:
                return optiesCase0[n];
            case 1:
                return optiesCase1[n];
            case 2:
                return optiesCase2[n];
        }
        return 'a';
    }


    public boolean SetInpute(char letter){
        if (goodChar == letter){
            score++;
            Scrembel();
            EndGame();
            return false;
        } else {
            return true;
        }
    }

    public int GetHyscore(){
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
            return 0;
        }
    }

}
