package main.scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public  class JuegoScene extends Scene {

    Scene cambiar;

    public JuegoScene(Parent root) {
        super(root);

        ImageView player1 = (ImageView) lookup("#p1");
        ImageView player2 = (ImageView) lookup("#p2");


        addEventHandler(KeyEvent.KEY_PRESSED, event -> {

            if(event.getCode() == KeyCode.W){
                player1.setY(player1.getY() - 10);
                Image image = new Image(getClass().getResourceAsStream("../images/bombermanarriba.gif"));
                player1.setImage(image);
            } else if (event.getCode() == KeyCode.A){
                player1.setX(player1.getX() - 10);
                Image image = new Image(getClass().getResourceAsStream("../images/bombermanizquierda.gif"));
                player1.setImage(image);
            } else if (event.getCode() == KeyCode.D){
                player1.setX(player1.getX() + 10);
                Image image = new Image(getClass().getResourceAsStream("../images/bombermanderecha.gif"));
                player1.setImage(image);
            } else if (event.getCode() == KeyCode.S) {
                player1.setY(player1.getY() + 10);
                Image image = new Image(getClass().getResourceAsStream("../images/bombermanabajo.gif"));
                player1.setImage(image);
            }



            if(event.getCode() == KeyCode.UP){
                player2.setY(player2.getY() - 10);
            } else if (event.getCode() == KeyCode.LEFT){
                player2.setX(player2.getX() - 10);
            } else if (event.getCode() == KeyCode.RIGHT){
                player2.setX(player2.getX() + 10);
            } else if (event.getCode() == KeyCode.DOWN) {
                player2.setY(player2.getY() + 10);
            }
        });
        setFill(Color.TRANSPARENT);
    }

}
