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
                p1 = new Image(getClass().getResourceAsStream("../images/linkabajo.png"));
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
                p1 = new Image(getClass().getResourceAsStream("../images/pikachuabajo.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "sonictabla":
                p1 = new Image(getClass().getResourceAsStream("../images/sonicadelante.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "bombermantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/bombermanabajo.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "ashtabla":
                p1 = new Image(getClass().getResourceAsStream("../images/ashjuego.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "pacmantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pacmanabajo.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "kirbytabla":
                p1 = new Image(getClass().getResourceAsStream("../images/kirbyizquierda.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
        }
        return player;

    }
    public ImageView personajeAbajo(AnchorPane tablero, String nombre, double tamañao){
        player.setFitHeight(tamañao);
        player.setFitWidth(tamañao);
        switch (nombre){
            case "linktabla":
                p1 = new Image(getClass().getResourceAsStream("../images/linkabajo.png"));
                player.setImage(p1);
                return  player;
            case "zeldatabla":
                p1 = new Image(getClass().getResourceAsStream("../images/zeldajuego.png"));
                player.setImage(p1);
                return  player;
            case "samustabla":
                p1 = new Image(getClass().getResourceAsStream("../images/samusjuego.png"));
                player.setImage(p1);
                return  player;
            case "gokutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/gokujuego.png"));
                player.setImage(p1);
                return  player;
            case "pikachutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pikachuabajo.png"));
                player.setImage(p1);
                return  player;
            case "sonictabla":
                p1 = new Image(getClass().getResourceAsStream("../images/sonicadelante.png"));
                player.setImage(p1);
                return  player;
            case "bombermantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/bombermanabajo.png"));
                player.setImage(p1);
                return  player;
            case "ashtabla":
                p1 = new Image(getClass().getResourceAsStream("../images/ashjuego.png"));
                player.setImage(p1);
                return  player;
            case "pacmantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pacmanabajo.png"));
                player.setImage(p1);
                tablero.getChildren().add(player);
                return  player;
            case "kirbytabla":
                p1 = new Image(getClass().getResourceAsStream("../images/kirbyizquierda.png"));
                player.setImage(p1);
                return  player;
        }
        return player;

    }
    public ImageView personajeDerecha(AnchorPane tablero, String nombre, double tamañao){
        player.setFitHeight(tamañao);
        player.setFitWidth(tamañao);
        switch (nombre){
            case "linktabla":
                p1 = new Image(getClass().getResourceAsStream("../images/linkderecha.png"));
                player.setImage(p1);
                return  player;
            case "zeldatabla":
                p1 = new Image(getClass().getResourceAsStream("../images/zeldajuego.png"));
                player.setImage(p1);
                return  player;
            case "samustabla":
                p1 = new Image(getClass().getResourceAsStream("../images/samusderecha.png"));
                player.setImage(p1);
                return  player;
            case "gokutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/gokuderecha.png"));
                player.setImage(p1);
                return  player;
            case "pikachutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pikachuderecha.png"));
                player.setImage(p1);
                return  player;
            case "sonictabla":
                p1 = new Image(getClass().getResourceAsStream("../images/sonicderecha.png"));
                player.setImage(p1);
                return  player;
            case "bombermantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/bombermanderecha.png"));
                player.setImage(p1);
                return  player;
            case "ashtabla":
                p1 = new Image(getClass().getResourceAsStream("../images/ashderecha.png"));
                player.setImage(p1);
                return  player;
            case "pacmantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pacmanderecha.png"));
                player.setImage(p1);
                return  player;
            case "kirbytabla":
                p1 = new Image(getClass().getResourceAsStream("../images/kirbyderecha.png"));
                player.setImage(p1);
                return  player;
        }
        return player;

    }
    public ImageView personajeIzquierda(AnchorPane tablero, String nombre, double tamañao){
        player.setFitHeight(tamañao);
        player.setFitWidth(tamañao);
        switch (nombre){
            case "linktabla":
                p1 = new Image(getClass().getResourceAsStream("../images/linkizquierda.png"));
                player.setImage(p1);
                return  player;
            case "zeldatabla":
                p1 = new Image(getClass().getResourceAsStream("../images/zeldajuego.png"));
                player.setImage(p1);
                return  player;
            case "samustabla":
                p1 = new Image(getClass().getResourceAsStream("../images/samusizquierda.png"));
                player.setImage(p1);
                return  player;
            case "gokutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/gokuizquierda.png"));
                player.setImage(p1);
                return  player;
            case "pikachutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pikachuizquierda.png"));
                player.setImage(p1);
                return  player;
            case "sonictabla":
                p1 = new Image(getClass().getResourceAsStream("../images/sonicizquierda .png"));
                player.setImage(p1);
                return  player;
            case "bombermantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/bombermanizquierda.png"));
                player.setImage(p1);
                return  player;
            case "ashtabla":
                p1 = new Image(getClass().getResourceAsStream("../images/ashizquierda.png"));
                player.setImage(p1);
                return  player;
            case "pacmantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pacmanizquierda.png"));
                player.setImage(p1);
                return  player;
            case "kirbytabla":
                p1 = new Image(getClass().getResourceAsStream("../images/kirbyizquierda.png"));
                player.setImage(p1);
                return  player;
        }
        return player;

    }
    public ImageView personajeArriba(AnchorPane tablero, String nombre, double tamañao){
        player.setFitHeight(tamañao);
        player.setFitWidth(tamañao);
        switch (nombre){
            case "linktabla":
                p1 = new Image(getClass().getResourceAsStream("../images/linkarriba.png"));
                player.setImage(p1);
                return  player;
            case "zeldatabla":
                p1 = new Image(getClass().getResourceAsStream("../images/zeldajuego.png"));
                player.setImage(p1);
                return  player;
            case "samustabla":
                p1 = new Image(getClass().getResourceAsStream("../images/samusjuego.png"));
                player.setImage(p1);
                return  player;
            case "gokutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/gokujuego.png"));
                player.setImage(p1);
                return  player;
            case "pikachutabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pikachuabajo.png"));
                player.setImage(p1);
                return  player;
            case "sonictabla":
                p1 = new Image(getClass().getResourceAsStream("../images/sonicadelante.png"));
                player.setImage(p1);
                return  player;
            case "bombermantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/bombermanarriba.png"));
                player.setImage(p1);
                return  player;
            case "ashtabla":
                p1 = new Image(getClass().getResourceAsStream("../images/ashjuego.png"));
                player.setImage(p1);
                return  player;
            case "pacmantabla":
                p1 = new Image(getClass().getResourceAsStream("../images/pacmanarriba.png"));
                player.setImage(p1);
                return  player;
            case "kirbytabla":
                p1 = new Image(getClass().getResourceAsStream("../images/kirbyderecha.png"));
                player.setImage(p1);
                return  player;
        }
        return player;

    }





}
