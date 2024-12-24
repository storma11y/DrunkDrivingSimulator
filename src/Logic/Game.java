package Logic;

import java.io.*;

public class Game {

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
