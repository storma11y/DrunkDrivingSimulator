package GUI;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Music {

    public static void PlayBackgrondMusic(InputStream musicInpute){
        Thread musicThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        Player player = new Player(musicInpute);
                        player.play();
                    }
                } catch (Exception e){

                }
            }
        });
        musicThread.start();
    }

    public static void PlaySoundEffect(String musicFile){
        Thread musicThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    Player player = new Player(new BufferedInputStream(new FileInputStream(musicFile)));
                    player.play();
                } catch (Exception e){

                }
            }
        });
        musicThread.start();
    }



}
