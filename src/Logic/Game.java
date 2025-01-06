package Logic;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Random;

public class Game {
    private int difficulty = 0;


    public void EndGame(int score){

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
        char[] optiesCase0 = {};
        char[] optiesCase1 = {};
        char[] optiesCase2 = {};
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


    public void SetInpute(char letter){



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
