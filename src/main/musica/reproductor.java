package main.musica;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class reproductor {

    public MediaView reproducir(String cancion){
        MediaView mediaView = new MediaView(null);
        if(cancion == "fondoinicio"){
            String path = "C:/Users/Onilink/IdeaProjects/Interfaz_a_patita/src/main/musica/fondoinicio.mp3";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaView = new MediaView(mediaPlayer);
            return mediaView;
        }else if(cancion == "fondojuego"){
            String path = "C:/Users/Onilink/IdeaProjects/Interfaz_a_patita/src/main/musica/fondojuego.mp3";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaView = new MediaView(mediaPlayer);
            return mediaView;
        }
        return null;
    }

}
