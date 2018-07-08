package main.Jugadores;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class elecciondePersonajes {

    ImageView player = new ImageView();
    Image p1 = null;
    public static int vida = 100;

    public ImageView crearPersonaje(AnchorPane tablero, String nombre, double tamañao){
        player.setFitHeight(tamañao);
        player.setFitWidth(tamañao);
        switch (nombre){
            case "linktabla":
                p1 = new Image(getClass().getResourceAsStream("../images/linkjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "zeldatabla":
                p1 = new Image(getClass().getResourceAsStream("../images/zeldajuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "samustabla":
                p1 = new Image(getClass().getResourceAsStream("../images/samusjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "gokutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/gokujuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "pikachutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pikachujuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "sonictabla":
                p1 = new Image(getClass().getResourceAsStream("../images/sonicjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "bombermantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/bombermanjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "ashtabla":
                p1 = new Image(getClass().getResourceAsStream("../images/ashjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "pacmantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pacmanjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "kirbytabla":
                p1 = new Image(getClass().getResourceAsStream("../images/kirbyjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
        }
        return player;

    }




}
