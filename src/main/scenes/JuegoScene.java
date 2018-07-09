package main.scenes;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Jugadores.elecciondePersonajes;
import main.proyectiles.Bomba;

import java.util.ArrayList;
import java.util.Random;

import static main.Jugadores.elecciondePersonajes.vida;


/**
 *
 * https://stackoverflow.com/questions/39923658/javafx-detect-mutliple-keyboard-keys-pressed-simultaneously
 */
public class JuegoScene extends Scene {

    Scene cambiar;
    AnchorPane tablero;
    ImageView player1;
    ImageView player2;
    public static double rangoBombas = 50;
    double pantallaancho = 1350;
    double pantallalaro = 900;
    public static double vidap1 = vida;
    public static double vidap2 = vida;
    static int aux2 = 0;


    private BooleanProperty upPressed = new SimpleBooleanProperty();
    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty downPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty rightPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty leftPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty spacePressed = new SimpleBooleanProperty();
    private BooleanProperty enterPressed = new SimpleBooleanProperty();

    private BooleanBinding anyPressed = upPressed.or(wPressed).or(downPressed).or(sPressed).or(rightPressed).or(dPressed).or(leftPressed).or(aPressed).or(spacePressed).or(enterPressed);

    public JuegoScene(Parent root) {
        super(root);

        player1 = (ImageView) root.lookup("#p1");
        player2 = (ImageView) root.lookup("#p2");
        tablero = (AnchorPane) root.lookup("#fondojuego");

        double tamañao = 50;
        elecciondePersonajes personaje1 = new elecciondePersonajes();
        elecciondePersonajes personaje2 = new elecciondePersonajes();
        player1 = personaje1.crearPersonaje(tablero,JuegoScene1.player1eleccion,tamañao);
        player2 = personaje2.crearPersonaje(tablero,JuegoScene1.player2eleccion,tamañao);
        player1.setX(pantallaancho-(pantallaancho-60));
        player1.setY(pantallalaro/2);
        player2.setX(pantallaancho-(pantallaancho-1290));
        player2.setY(pantallalaro/2);
        System.out.println(vidap1 +" "+vidap2);
        ArrayList<ImageView> obstaculos = new ArrayList<>();
        ArrayList<ImageView> obstaculosDestruidos = new ArrayList<>();
        crearmurosBordes(tamañao,tablero,obstaculos);
        crearmurosIrrompibles(tamañao,tablero,obstaculos);
        crearmurosRrompibles(tamañao,tablero,obstaculosDestruidos);


        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                wPressed.set(true);
            }
            if (event.getCode() == KeyCode.UP) {
                upPressed.set(true);
            }
            if (event.getCode() == KeyCode.DOWN) {
                downPressed.set(true);
            }
            if (event.getCode() == KeyCode.S) {
                sPressed.set(true);
            }
            if (event.getCode() == KeyCode.RIGHT) {
                rightPressed.set(true);
            }
            if (event.getCode() == KeyCode.D) {
                dPressed.set(true);
            }
            if (event.getCode() == KeyCode.LEFT) {
                leftPressed.set(true);
            }
            if (event.getCode() == KeyCode.A) {
                aPressed.set(true);
            }
            if (event.getCode() == KeyCode.SPACE) {
                spacePressed.set(true);
            }
            if (event.getCode() == KeyCode.ENTER) {
                enterPressed.set(true);
            }
        });
        setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W) {
                wPressed.set(false);
            }
            if (event.getCode() == KeyCode.UP) {
                upPressed.set(false);
            }

            if (event.getCode() == KeyCode.DOWN) {
                downPressed.set(false);
            }
            if (event.getCode() == KeyCode.S) {
                sPressed.set(false);
            }
            if (event.getCode() == KeyCode.RIGHT) {
                rightPressed.set(false);
            }
            if (event.getCode() == KeyCode.D) {
                dPressed.set(false);
            }
            if (event.getCode() == KeyCode.LEFT) {
                leftPressed.set(false);
            }
            if (event.getCode() == KeyCode.A) {
                aPressed.set(false);
            }
             if (event.getCode() == KeyCode.SPACE) {
                 spacePressed.set(false);
             }
             if (event.getCode() == KeyCode.ENTER) {
                 enterPressed.set(false);
             }
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long timestamp) {

                int velocidad = 5;

                if (upPressed.get()) {
                    ImageView aux = new ImageView();
                    aux.setX(player2.getX());
                    aux.setY(player2.getY()-velocidad);
                    aux.setFitWidth(tamañao);
                    aux.setFitHeight(tamañao);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                            if (!choques(player2, obstaculos)) {
                                player2.setY(player2.getY() - velocidad);
                            }
                    }
                }

                if (downPressed.get()) {
                    ImageView aux = new ImageView();
                    aux.setX(player2.getX());
                    aux.setY(player2.getY()+velocidad);
                    aux.setFitWidth(tamañao);
                    aux.setFitHeight(tamañao);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                            if (!choques(player2, obstaculos)) {
                                player2.setY(player2.getY() + velocidad);
                            }
                    }
                }
                if (rightPressed.get()) {
                        ImageView aux = new ImageView();
                        aux.setX(player2.getX()+velocidad);
                        aux.setY(player2.getY());
                        aux.setFitWidth(tamañao);
                        aux.setFitHeight(tamañao);
                        if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                            if (!choques(player2, obstaculos)) {
                                player2.setX(player2.getX() + velocidad);
                            }
                        }
                }

                if (leftPressed.get()) {
                        ImageView aux = new ImageView();
                        aux.setX(player2.getX() - velocidad);
                        aux.setY(player2.getY());
                        aux.setFitWidth(tamañao);
                        aux.setFitHeight(tamañao);
                        if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                            if (player2.getX() >= 61) {
                                if (!choques(player2, obstaculos)) {
                                    player2.setX(player2.getX() - velocidad);
                                }
                            }
                        }
                }
                if (wPressed.get()) {
                    ImageView aux = new ImageView();
                    aux.setX(player1.getX());
                    aux.setY(player1.getY()-velocidad);
                    aux.setFitWidth(tamañao);
                    aux.setFitHeight(tamañao);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player1, obstaculos)) {
                            player1.setY(player1.getY() - velocidad);
                        }
                    }

                }
                if (sPressed.get()) {
                    ImageView aux = new ImageView();
                    aux.setX(player1.getX());
                    aux.setY(player1.getY()+velocidad);
                    aux.setFitWidth(tamañao);
                    aux.setFitHeight(tamañao);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player1, obstaculos)) {
                            player1.setY(player1.getY() + velocidad);
                        }
                    }
                }
                if (dPressed.get()) {
                    ImageView aux = new ImageView();
                    aux.setX(player1.getX()+velocidad);
                    aux.setY(player1.getY());
                    aux.setFitWidth(tamañao);
                    aux.setFitHeight(tamañao);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player1, obstaculos)) {
                            player1.setX(player1.getX() + velocidad);
                        }
                    }

                }
                if (aPressed.get()) {
                    ImageView aux = new ImageView();
                    aux.setX(player1.getX() - velocidad);
                    aux.setY(player1.getY());
                    aux.setFitWidth(tamañao);
                    aux.setFitHeight(tamañao);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (player1.getX() >= 61) {
                            if (!choques(player1, obstaculos)) {
                                player1.setX(player1.getX() - velocidad);
                            }
                        }
                    }

                }
                if (spacePressed.get()) {
                    if (!wPressed.get() && !aPressed.get() && !dPressed.get() && !sPressed.get()) {
                        ImageView bombita;
                        Bomba bomba = new Bomba();
                        bombita = bomba.crearBomba(player1, tablero);
                        ImageView aux1, aux2, aux3, aux4;
                        aux1 = auxiliares(bombita, tamañao);
                        aux2 = auxiliares(bombita, tamañao);
                        aux3 = auxiliares(bombita, tamañao);
                        aux4 = auxiliares(bombita, tamañao);
                        aux1.setY(bombita.getY() - rangoBombas);
                        aux2.setY(bombita.getY() + rangoBombas);
                        aux3.setX(bombita.getX() - rangoBombas);
                        aux4.setX(bombita.getX() + rangoBombas);
                        if (!choques(aux1, obstaculosDestruidos)) {
                            System.out.println("no hay bloques arriba");
                        } else {
                            destruir(aux1, obstaculosDestruidos);
                        }
                        if (!choques(aux2, obstaculosDestruidos)) {
                            System.out.println("no hay bloques abajo");
                        } else {
                            destruir(aux2, obstaculosDestruidos);
                        }
                        if (!choques(aux3, obstaculosDestruidos)) {
                            System.out.println("no hay bloques a la izquierda");
                        } else {
                            destruir(aux3, obstaculosDestruidos);
                        }
                        if (!choques(aux4, obstaculosDestruidos)) {
                            System.out.println("no hay bloques a la derecha");
                        } else {
                            destruir(aux4, obstaculosDestruidos);
                        }
                    }

                }
                if (enterPressed.get()) {
                    if (!wPressed.get() && !aPressed.get() && !dPressed.get() && !sPressed.get()) {
                        ImageView bombita;
                        Bomba bomba = new Bomba();
                        bombita = bomba.crearBomba(player2,tablero);
                        ImageView aux1, aux2, aux3, aux4;
                        aux1= auxiliares(bombita,tamañao);
                        aux2= auxiliares(bombita,tamañao);
                        aux3= auxiliares(bombita,tamañao);
                        aux4= auxiliares(bombita,tamañao);
                        aux1.setY(bombita.getY()-rangoBombas);
                        aux2.setY(bombita.getY()+rangoBombas);
                        aux3.setX(bombita.getX()-rangoBombas);
                        aux4.setX(bombita.getX()+rangoBombas);
                        if(!choques(aux1,obstaculosDestruidos)){
                            System.out.println("no hay bloques arriba");
                        }
                        else {
                            destruir(aux1,obstaculosDestruidos);
                        }
                        if(!choques(aux2,obstaculosDestruidos)){
                            System.out.println("no hay bloques abajo");
                        }
                        else {
                            destruir(aux2,obstaculosDestruidos);
                        }
                        if(!choques(aux3,obstaculosDestruidos)){
                            System.out.println("no hay bloques a la izquierda");
                        }
                        else {
                            destruir(aux3,obstaculosDestruidos);
                        }
                        if(!choques(aux4,obstaculosDestruidos)){
                            System.out.println("no hay bloques a la derecha");
                        }
                        else {
                            destruir(aux4,obstaculosDestruidos);
                        }
                    }
                }
            }
        };

        anyPressed.addListener((obs, wasPressed, isNowPressed) -> {
            if (isNowPressed) {
                timer.start();
            } else {
                timer.stop();
            }
        });

        setFill(Color.TRANSPARENT);
    }

    public void crearmurosBordes(double tamañao, AnchorPane tablero, ArrayList<ImageView> listaObstaculos){
        int enx = 0;
        int enY = 0;

        while (enx <= pantallaancho) {
            if(enx == 0 || enx == pantallaancho){
                while(enY <= pantallalaro){
                    Image muro = new Image(getClass().getResourceAsStream("../images/muro2.jpg"));
                    ImageView obstaculo = new ImageView();
                    obstaculo.setImage(muro);
                    obstaculo.setY(enY);
                    obstaculo.setX(enx);
                    obstaculo.setFitHeight(tamañao);
                    obstaculo.setFitWidth(tamañao);
                    tablero.getChildren().add(obstaculo);

                    listaObstaculos.add(obstaculo);
                    if(enY == pantallalaro && enx == 0){
                        while (enx <= pantallaancho){
                            Image muro1 = new Image(getClass().getResourceAsStream("../images/muro2.jpg"));
                            ImageView obstaculo1 = new ImageView();
                            obstaculo1.setImage(muro1);
                            obstaculo1.setY(enY);
                            obstaculo1.setX(enx);
                            obstaculo1.setFitHeight(tamañao);
                            obstaculo1.setFitWidth(tamañao);
                            tablero.getChildren().add(obstaculo1);
                            enx += 50;
                            listaObstaculos.add(obstaculo1);
                        }
                        enx =0;

                    }
                    enY += 50;

                }

                enY = 0;
            }
            Image muro = new Image(getClass().getResourceAsStream("../images/muro2.jpg"));
            ImageView obstaculo = new ImageView();
            obstaculo.setImage(muro);
            obstaculo.setY(enY);
            obstaculo.setX(enx);
            obstaculo.setFitHeight(tamañao);
            obstaculo.setFitWidth(tamañao);
            tablero.getChildren().add(obstaculo);
            enx += 50;
            listaObstaculos.add(obstaculo);

        }
    }
    public void crearmurosIrrompibles(double tamañao, AnchorPane tablero, ArrayList<ImageView> listaObstaculos){
        int distancia= 150;
        int enx = distancia;
        int enY = distancia;

        while (enY < pantallalaro){
            while (enx <= pantallaancho-distancia) {
                Image muro = new Image(getClass().getResourceAsStream("../images/muro.jpg"));
                ImageView obstaculo = new ImageView();
                obstaculo.setImage(muro);
                obstaculo.setY(enY);
                obstaculo.setX(enx);
                obstaculo.setFitHeight(tamañao);
                obstaculo.setFitWidth(tamañao);
                tablero.getChildren().add(obstaculo);
                enx += distancia;
                listaObstaculos.add(obstaculo);

            }
            enx= distancia;
            enY += distancia;
        }


    }
    public void crearmurosRrompibles(double tamañao, AnchorPane tablero, ArrayList<ImageView> listaObstaculos){
        int distancia= 75;
        int enx = distancia*3;
        int enY = distancia;

        while (enY < pantallalaro){
            while (enx <= pantallaancho-distancia*3) {
                Image muro = new Image(getClass().getResourceAsStream("../images/muro3.jpg"));
                ImageView obstaculo = new ImageView();
                obstaculo.setImage(muro);
                obstaculo.setY(enY);
                obstaculo.setX(enx);
                obstaculo.setFitHeight(tamañao);
                obstaculo.setFitWidth(tamañao);
                tablero.getChildren().add(obstaculo);
                enx += distancia*2;
                listaObstaculos.add(obstaculo);

            }
            enx= distancia*3;
            enY += distancia*2;
        }


    }
    public boolean choques (ImageView jugador, ArrayList<ImageView> bloques){
        int aux=0;
        while (aux <= bloques.size()-1) {

            if (jugador.getBoundsInParent().intersects(bloques.get(aux).getBoundsInParent())) {
                return true;
            }
            else {
                aux +=1;

            }
        }
        return false;
    }
    public void destruir (ImageView bomba, ArrayList<ImageView> bloques){
        int aux=0;
        while (aux <= bloques.size()-1) {

            if (bomba.getBoundsInParent().intersects(bloques.get(aux).getBoundsInParent())) {
                tablero.getChildren().remove(tablero.getChildren().indexOf(bloques.get(aux)));
                bloques.remove(aux);
            }
            else {
                aux +=1;
            }
        }
    }
    public ImageView auxiliares (ImageView bomba,double tamañao){
        ImageView aux= new ImageView();
        aux.setY(bomba.getY()-rangoBombas);
        aux.setX(bomba.getX()-rangoBombas);
        aux.setFitHeight(tamañao);
        aux.setFitWidth(tamañao);
        return aux;
    }







}
