package Avatar;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;

public class Music implements Runnable{
    static String[] paths = {"avatar_begins.mp3", "a_1.mp3", "a_2.mp3", "a_3.mp3", "a_4.mp3"};
    private static MediaPlayer player;
    Thread th = new Thread(this);
    public void start(){this.th.start();}
    public Music(){}
    static int musicNum;
    public void setMusicNum(int i){musicNum = i;}
    public void run() {
        play(musicNum);
    }
    public void stop(){
        player.stop();
    }
    public void play(int num) {
        new JFXPanel();
        player = new MediaPlayer(new Media(new File(paths[num]).toURI().toString()));
        player.setVolume(0.08);
        player.play();

    }
}
