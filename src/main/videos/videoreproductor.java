package main.videos;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class videoreproductor {


    public  static MediaPlayer reproducir(String video){

        if(video == "videoinicio"){
            String path = "C:/Users/Onilink/IdeaProjects/ProyectoPOO_1.0/src/main/images/4.mp4";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            return mediaPlayer;
        }
        return null;
    }

}
