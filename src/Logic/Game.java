package Logic;

import java.io.*;
import java.util.Random;
import java.util.Timer;

public class Game {

    public char goodChar = ' ';
    public char foeiChar = ' ';

    public int score = 0;

    private long starttijd;

    public Game() {
        starttijd = System.currentTimeMillis();
        Scrembel();
    }

    private int GetDifficulty(){
        if (score <= 15) {
            return 0;
        } else if (score >= 15 && score <= 30) {
            return 1;
        } else {
            return 2;
        }
    }
    public int GetTime(){
        return (int) (System.currentTimeMillis() - starttijd)+BerekenTimeVermindering();
    }

    private int BerekenTimeVermindering(){
        if (score >= 60){
            return 5500;
        } else {
            return (55/36)*score*score;
        }

    }

    private void Scrembel(){
        goodChar = GetRandomChar();
        foeiChar = GetRandomChar();
        while (goodChar == foeiChar){
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
        char[] optiesCase2 = {'L', 'I', '|', '*', 'j', '(', '*', 'g', '&', '%', '^', 'J', 'K', '}', '{'};

        switch (GetDifficulty()) {
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
            starttijd = System.currentTimeMillis();
            return false;
        } else {
            EndGame();
            return true;
        }
    }



}
