package main.proyectiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Bomba extends Thread{

    public Bomba(String msg){
        super(msg);
    }

    public ImageView crearBomba(ImageView player, AnchorPane tablero) {
        Image bomba = new Image(getClass().getResourceAsStream("../images/bombagif.gif"));
        ImageView bombamob = new ImageView(bomba);
        bombamob.setImage(bomba);
        bombamob.setFitWidth(50);
        bombamob.setFitHeight(50);
        bombamob.setX(player.getX());
        bombamob.setY(player.getY());
        tablero.getChildren().add(bombamob);

        return bombamob;
    }

    public void destruirBomba(ImageView bomba,AnchorPane tablero){
        tablero.getChildren().remove(tablero.getChildren().indexOf(bomba));
    }

    public void run(ImageView player,AnchorPane tablero){
        ImageView bomba = crearBomba(player,tablero);
        //destruirBomba(bomba,tablero);
    }

}
