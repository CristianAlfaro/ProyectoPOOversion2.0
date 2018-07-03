package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.musica.reproductor;
import main.scenes.FactoryScene;
import main.scenes.JuegoScene;
import main.scenes.TypeScene;

import java.io.File;


public class mainApp extends Application {

    private static mainApp main;
    static reproductor reproductor = new reproductor();
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(FactoryScene.getScene(TypeScene.MAIN,this));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        reproductor.reproducir("fondoinicio");
    }


    public static void main(String... args){
        launch(args);
    }

    public static mainApp obtenerdirrectorio(){
        main = new mainApp();
        return main;
    }

    public static mainApp getInstance() {
        return main;
    }

    public static void getMusic(){
        MediaPlayer mediaPlayer = reproductor.reproducir("fondoinicio").getMediaPlayer();
        mediaPlayer.stop();
    }

}
