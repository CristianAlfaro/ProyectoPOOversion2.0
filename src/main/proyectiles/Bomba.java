package main.proyectiles;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Bomba{


    public ImageView crearBomba(ImageView player, AnchorPane tablero) {
        Image bomba = new Image(getClass().getResourceAsStream("../images/bombagif.gif"));
        ImageView bombamob = new ImageView(bomba);
        bombamob.setImage(bomba);
        bombamob.setFitWidth(50);
        bombamob.setFitHeight(50);
        bombamob.setX(player.getX());
        bombamob.setY(player.getY());
        tablero.getChildren().add(bombamob);
        Timeline timeline = new Timeline(

                new KeyFrame(Duration.seconds(2), new KeyValue(bombamob.imageProperty(), bomba)),

                new KeyFrame(Duration.seconds(3), new KeyValue(bombamob.imageProperty(), null))

        );
        timeline.play();

        return bombamob;
    }

    public void destruirBomba(ImageView bomba,AnchorPane tablero){

    }


}
