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
        GridPane tablero = (GridPane) lookup("#tablero")    ;


        addEventHandler(KeyEvent.KEY_PRESSED, event -> {

            if(event.getCode() == KeyCode.W){
                    tablero.add(player1, tablero.getColumnIndex(player1), tablero.getRowIndex(player1) - 1);
            } else if (event.getCode() == KeyCode.A){
                if(tablero.getColumnIndex(player1)-1 != 0)
                    tablero.add(player1,tablero.getColumnIndex(player1)-1,tablero.getRowIndex(player1));
            } else if (event.getCode() == KeyCode.D){
                if(tablero.getColumnIndex(player1)+1 != 16)
                    tablero.add(player1,tablero.getColumnIndex(player1)+1,tablero.getRowIndex(player1));
            } else if (event.getCode() == KeyCode.S) {
                if(tablero.getRowIndex(player1)+1 != 12)
                    tablero.add(player1,tablero.getColumnIndex(player1),tablero.getRowIndex(player1)+1);
            }
            else if(event.getCode() == KeyCode.UP){
                    tablero.add(player2, tablero.getColumnIndex(player2), tablero.getRowIndex(player2) - 1);
            } else if (event.getCode() == KeyCode.LEFT){
                if(tablero.getColumnIndex(player2)-1 != 0)
                    tablero.add(player2,tablero.getColumnIndex(player2)-1,tablero.getRowIndex(player2));
            } else if (event.getCode() == KeyCode.RIGHT){
                if(tablero.getColumnIndex(player2)+1 != 16)
                    tablero.add(player2,tablero.getColumnIndex(player2)+1,tablero.getRowIndex(player2));
            } else if (event.getCode() == KeyCode.DOWN) {
                if(tablero.getRowIndex(player2)+1 != 12)
                    tablero.add(player2,tablero.getColumnIndex(player2),tablero.getRowIndex(player2)+1);
            }
        });
        setFill(Color.TRANSPARENT);
    }

}
