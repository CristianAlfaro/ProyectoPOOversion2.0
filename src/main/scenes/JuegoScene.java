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
    public static AnchorPane tablero;
    public static double vidap1 = vida;
    public static double vidap2 = vida;
    public static double rangobombaP1 = 50;
    public static double rangobombaP2 = 50;
    
    public static  ArrayList<ImageView> obstaculos;
    public static  ArrayList<ImageView> obstaculosDestruidos;

    public static ImageView player1;
    public static ImageView player2;

    double pantallaancho = 1350;
    double pantallalaro = 900;



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
        obstaculos = new ArrayList<>();
        obstaculosDestruidos = new ArrayList<>();
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
                    ImageView aux = auxiliares(player2,tamañao);
                    player2 = personaje2.personajeArriba(tablero,JuegoScene1.player2eleccion,tamañao);
                    aux.setY(player2.getY()-velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                            if (!choques(player2, obstaculos)) {
                                player2.setY(player2.getY() - velocidad);
                            }
                    }
                }

                if (downPressed.get()) {
                    ImageView aux = auxiliares(player2,tamañao);
                    player2 = personaje2.personajeAbajo(tablero,JuegoScene1.player2eleccion,tamañao);
                    aux.setY(player2.getY()+velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                            if (!choques(player2, obstaculos)) {
                                player2.setY(player2.getY() + velocidad);
                            }
                    }
                }
                if (rightPressed.get()) {
                    ImageView aux = auxiliares(player2,tamañao);
                    player2 = personaje2.personajeDerecha(tablero,JuegoScene1.player2eleccion,tamañao);
                    aux.setX(player2.getX()+velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player2, obstaculos)) {
                            player2.setX(player2.getX() + velocidad);
                            }
                        }
                }

                if (leftPressed.get()) {
                    ImageView aux = auxiliares(player2,tamañao);
                    player2 = personaje2.personajeIzquierda(tablero,JuegoScene1.player2eleccion,tamañao);
                    aux.setX(player2.getX() - velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (player2.getX() >= 61) {
                            if (!choques(player2, obstaculos)) {
                                    player2.setX(player2.getX() - velocidad);
                            }
                        }
                    }
                }
                if (wPressed.get()) {
                    ImageView aux = auxiliares(player1,tamañao);
                    player1 = personaje1.personajeArriba(tablero,JuegoScene1.player1eleccion,tamañao);
                    aux.setY(player1.getY()-velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player1, obstaculos)) {
                            player1.setY(player1.getY() - velocidad);
                        }
                    }

                }
                if (sPressed.get()) {
                    ImageView aux = auxiliares(player1,tamañao);
                    player1 = personaje1.personajeAbajo(tablero,JuegoScene1.player1eleccion,tamañao);
                    aux.setY(player1.getY()+velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player1, obstaculos)) {
                            player1.setY(player1.getY() + velocidad);
                        }
                    }
                }
                if (dPressed.get()) {
                    ImageView aux = auxiliares(player1,tamañao);
                    player1 = personaje1.personajeDerecha(tablero,JuegoScene1.player1eleccion,tamañao);
                    aux.setX(player1.getX()+velocidad);
                    if (!choques(aux, obstaculos) && !choques(aux,obstaculosDestruidos)) {
                        if (!choques(player1, obstaculos)) {
                            player1.setX(player1.getX() + velocidad);
                        }
                    }

                }
                if (aPressed.get()) {
                    ImageView aux = auxiliares(player1,tamañao);
                    player1 = personaje1.personajeIzquierda(tablero,JuegoScene1.player1eleccion,tamañao);
                    aux.setX(player1.getX() - velocidad);
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
                        aux1 = auxiliares(bombita, rangobombaP1);
                        aux1.setFitWidth(tamañao);
                        aux2 = auxiliares(bombita, rangobombaP1);
                        aux2.setFitWidth(tamañao);
                        aux3 = auxiliares(bombita, rangobombaP1);
                        aux3.setFitHeight(tamañao);
                        aux4 = auxiliares(bombita, rangobombaP1);
                        aux4.setFitHeight(tamañao);
                        aux1.setY(bombita.getY() - rangobombaP1);
                        aux2.setY(bombita.getY() + tamañao);
                        aux3.setX(bombita.getX() - rangobombaP1);
                        aux4.setX(bombita.getX() + tamañao);
                        bomba.crearBomba(player1,tablero,aux1,aux2,aux3,aux4);
                    }
                }
                if (enterPressed.get()) {
                    if (!upPressed.get() && !downPressed.get() && !rightPressed.get() && !leftPressed.get()) {
                        ImageView bombita;
                        Bomba bomba = new Bomba();
                        bombita = bomba.crearBomba(player2, tablero);
                        ImageView aux1, aux2, aux3, aux4;
                        aux1 = auxiliares(bombita, rangobombaP2);
                        aux1.setFitWidth(tamañao);
                        aux2 = auxiliares(bombita, rangobombaP2);
                        aux2.setFitWidth(tamañao);
                        aux3 = auxiliares(bombita, rangobombaP2);
                        aux3.setFitHeight(tamañao);
                        aux4 = auxiliares(bombita, rangobombaP2);
                        aux4.setFitHeight(tamañao);
                        aux1.setY(bombita.getY() - rangobombaP2);
                        aux2.setY(bombita.getY() + tamañao);
                        aux3.setX(bombita.getX() - rangobombaP2);
                        aux4.setX(bombita.getX() + tamañao);
                        bomba.crearBomba(player2,tablero,aux1,aux2,aux3,aux4);

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
/*
 * CREA LOS MUROS QUE PASAN AL REDEDOR DE LA PANTALLA PARA RESTRINGIR EL PASO
 */
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
/*
 * CREA LOS MUROS QUE DEVIDEN EL CAMINO EN CUADRICULAS
 */
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
                obstaculo.setFitHeight(tamañao+15);
                obstaculo.setFitWidth(tamañao+15);
                tablero.getChildren().add(obstaculo);
                enx += distancia;
                listaObstaculos.add(obstaculo);

            }
            enx= distancia;
            enY += distancia;
        }


    }
/*
 * CREA LOS MUROS QUE PODRAN ROMPERSE
 */
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
                obstaculo.setFitHeight(tamañao+10);
                obstaculo.setFitWidth(tamañao+10);
                tablero.getChildren().add(obstaculo);
                enx += distancia*2;
                listaObstaculos.add(obstaculo);

            }
            enx= distancia*3;
            enY += distancia*2;
        }


    }
/*
 * DETECTA LOS CHOQUES
 */
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

    public static boolean choquesPlayer (ImageView jugador, ImageView bomba){
        if (jugador.getBoundsInParent().intersects(bomba.getBoundsInParent())) {
                return true;
            }
            else {
                return false;
            }


    }
/*
 * DESTRUYE UN BLOQUE EN CONTACTO
 */
    public static ImageView destruir (ImageView bomba, ArrayList<ImageView> bloques){
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
        return null;
    }
/*
 * GENERA LOS BLOQUES AUXILIARES PARA DIFERENTES FUNCIONES
 */
    public ImageView auxiliares (ImageView bomba,double tamañao){
        ImageView aux= new ImageView();
        aux.setY(bomba.getY());
        aux.setX(bomba.getX());
        aux.setFitHeight(tamañao);
        aux.setFitWidth(tamañao);
        return aux;
    }







}
