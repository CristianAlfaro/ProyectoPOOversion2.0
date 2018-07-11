package main.musica;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class reproductor {
    MediaView mediaView = new MediaView(null);

    public static MediaPlayer mediaPlayer;

    public MediaView reproducir(String cancion){

        if(cancion == "fondoinicio"){
            String path = "../ProyectoPOO_1.0/src/main/musica/fondoinicio.mp3";
            Media media = new Media(new File(path).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView = new MediaView(mediaPlayer);
            return mediaView;
        }else if(cancion == "fondojuego"){
            String path = "../ProyectoPOO_1.0/src/main/musica/fondojuego.mp3";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer2 = new MediaPlayer(media);
            mediaView = new MediaView(mediaPlayer2);
            return mediaView;
        }
        return null;
    }
}
