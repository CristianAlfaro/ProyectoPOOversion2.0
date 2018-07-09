package main.proyectiles;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import main.scenes.JuegoScene;

import static main.scenes.JuegoScene.*;

public class Bomba{


    public ImageView crearBomba(ImageView player, AnchorPane tablero,ImageView aux1, ImageView aux2, ImageView aux3, ImageView aux4) {
        Image bomba = new Image(getClass().getResourceAsStream("../images/bomba.gif"));
        Image image1 = new Image(getClass().getResourceAsStream("../images/aux1.png"));
        Image image2 = new Image(getClass().getResourceAsStream("../images/aux2.png"));
        Image image3 = new Image(getClass().getResourceAsStream("../images/aux3.png"));
        Image image4 = new Image(getClass().getResourceAsStream("../images/aux4.png"));
        Image image5 = new Image(getClass().getResourceAsStream("../images/centroaux.png"));

        ImageView bombamob = new ImageView(bomba);
        bombamob.setImage(bomba);
        bombamob.setFitWidth(50);
        bombamob.setFitHeight(50);
        bombamob.setX(player.getX());
        bombamob.setY(player.getY());
        tablero.getChildren().addAll(bombamob,aux1,aux2,aux3,aux4);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), new KeyValue(bombamob.imageProperty(), bomba)),
                new KeyFrame(Duration.seconds(2), new KeyValue(aux1.imageProperty(), image1)),
                new KeyFrame(Duration.seconds(2), new KeyValue(aux2.imageProperty(), image2)),
                new KeyFrame(Duration.seconds(2), new KeyValue(aux3.imageProperty(), image3)),
                new KeyFrame(Duration.seconds(2), new KeyValue(aux4.imageProperty(), image4)),
                new KeyFrame(Duration.seconds(2), new KeyValue(bombamob.imageProperty(), image5)),
                new KeyFrame(Duration.seconds(3), new KeyValue(aux1.imageProperty(), null)),
                new KeyFrame(Duration.seconds(3), new KeyValue(aux2.imageProperty(), null)),
                new KeyFrame(Duration.seconds(3), new KeyValue(aux3.imageProperty(), null)),
                new KeyFrame(Duration.seconds(3), new KeyValue(aux4.imageProperty(), null)),
                new KeyFrame(Duration.seconds(3), new KeyValue(bombamob.imageProperty(), null))
        );
        timeline.play();
        JuegoScene.destruir(aux1,obstaculosDestruidos);
        JuegoScene.destruir(aux2,obstaculosDestruidos);
        JuegoScene.destruir(aux3,obstaculosDestruidos);
        JuegoScene.destruir(aux4,obstaculosDestruidos);
        if(player == player1){
            if(JuegoScene.choquesPlayer(player2,aux1)){
                if(vidap2 >= 0){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap2 -=25;
                    rangobombaP2 +=50;
                    System.out.println("te queda "+vidap2+" de vide solamente" );
                    System.out.println("perotus bombas son mas poderosas");
                }
                else{
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }else if(JuegoScene.choquesPlayer(player2,aux2)){
                if(vidap2 >= 0){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap2 -=25;
                    rangobombaP2 +=50;
                    System.out.println("te queda "+vidap2+" de vide solamente" );
                    System.out.println("perotus bombas son mas poderosas");
                }
                else{
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }else if(JuegoScene.choquesPlayer(player2,aux3)){
                if(vidap2 >= 0){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap2 -=25;
                    rangobombaP2 +=50;
                    System.out.println("te queda "+vidap2+" de vide solamente" );
                    System.out.println("perotus bombas son mas poderosas");
                }
                else{
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }else if(JuegoScene.choquesPlayer(player2,aux4)){
                if(vidap2 >= 0){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap2 -=25;
                    rangobombaP2 +=50;
                    System.out.println("te queda "+vidap2+" de vide solamente" );
                    System.out.println("perotus bombas son mas poderosas");
                }
                else{
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }
        if(player == player2) {
            if (JuegoScene.choquesPlayer(player1, aux1)) {
                if (vidap1 >= 0) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap1 -= 25;
                    rangobombaP1 += 50;
                    System.out.println("te queda " + vidap1 + " de vide solamente");
                    System.out.println("perotus bombas son mas poderosas");
                } else {
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }else if (JuegoScene.choquesPlayer(player1, aux2)) {
                if (vidap1 >= 0) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap1 -= 25;
                    rangobombaP1 += 50;
                    System.out.println("te queda " + vidap1 + " de vide solamente");
                    System.out.println("perotus bombas son mas poderosas");
                } else {
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }else if (JuegoScene.choquesPlayer(player1, aux3)) {
                if (vidap1 >= 0) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap1 -= 25;
                    rangobombaP1 += 50;
                    System.out.println("te queda " + vidap1 + " de vide solamente");
                    System.out.println("perotus bombas son mas poderosas");
                } else {
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }else if (JuegoScene.choquesPlayer(player1, aux4)) {
                if (vidap1 >= 0) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vidap1 -= 25;
                    rangobombaP1 += 50;
                    System.out.println("te queda " + vidap1 + " de vide solamente");
                    System.out.println("perotus bombas son mas poderosas");
                } else {
                    tablero.getChildren().remove(tablero.getChildren().indexOf(player));
                }
            }
        }


        }

        return bombamob;
    }

    public ImageView crearBomba(ImageView player, AnchorPane tablero) {

        ImageView bombamob = new ImageView();
        bombamob.setFitWidth(50);
        bombamob.setFitHeight(50);
        bombamob.setX(player.getX());
        bombamob.setY(player.getY());
        tablero.getChildren().add(bombamob);

        return bombamob;
    }


}
