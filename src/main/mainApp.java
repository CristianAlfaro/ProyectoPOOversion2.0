package main;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.musica.reproductor;
import main.scenes.FactoryScene;
import main.scenes.TypeScene;
import main.videos.videoreproductor;


public class mainApp extends Application {

    private static mainApp main;
    public static reproductor reproductor = new reproductor();

    @Override

    public void start(Stage primaryStage) throws Exception {


        reproductor.reproducir("fondoinicio").getMediaPlayer().play();
        primaryStage.setScene(FactoryScene.getScene(TypeScene.SELLECCION , this));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        System.out.println(primaryStage);
        primaryStage.show();

        main = this;
    }

    public static void main(String... args) {
        launch(args);

    }

    public static mainApp obtenerdirrectorio() {
        main = new mainApp();
        return main;
    }

    public static mainApp getInstance() {
        return main;
    }

    public static reproductor obtenerReproductor(){
        return reproductor;
    }
}
