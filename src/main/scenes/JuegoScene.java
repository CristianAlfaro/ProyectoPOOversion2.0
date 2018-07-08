package main.scenes;

import javafx.animation.AnimationTimer;
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
import main.Jugadores.elecciondePersonajes;
import main.proyectiles.Bomba;

import java.util.ArrayList;

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
    double pantallaancho = 1350;
    double pantallalaro = 900;
    public static double vidap1 = vida;
    public static double vidap2 = vida;


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
        crearmurosBordes(tamañao,tablero,obstaculos);
        crearmurosIrrompibles(tamañao,tablero,obstaculos);


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
                    if (!choques(player2, obstaculos)) {
                        player2.setY(player2.getY() - velocidad);
                    }else {
                        player2.setY(player2.getY() + velocidad*2);
                    }
                }

                if (downPressed.get()) {
                    if (!choques(player2, obstaculos)) {
                        player2.setY(player2.getY() + velocidad);
                    }else {
                        player2.setY(player2.getY() - velocidad*2);
                    }
                }
                if (rightPressed.get()) {
                    if (!choques(player2, obstaculos)) {
                        player2.setX(player2.getX() + velocidad);
                    }else {
                        player2.setX(player2.getX());
                    }
                }

                if (leftPressed.get()) {
                    if (!choques(player2, obstaculos)) {
                        player2.setX(player2.getX() - velocidad);
                    }else {
                        player2.setX(player2.getX() + velocidad*2      );
                    }
                }
                if (wPressed.get()) {
                    if (!choques(player1, obstaculos)) {
                            player1.setY(player1.getY() - velocidad);
                    }else {
                        player1.setY(player1.getY() + velocidad*2);
                    }

                }
                if (sPressed.get()) {
                    if (!choques(player1, obstaculos)) {
                        player1.setY(player1.getY() + velocidad);
                    }else {
                        player1.setY(player1.getY() - velocidad*2);
                    }
                }
                if (dPressed.get()) {
                    if (!choques(player1, obstaculos)) {
                        player1.setX(player1.getX() + velocidad);
                    }else {
                        player1.setX(player1.getX());
                    }

                }
                if (aPressed.get()) {
                    if (!choques(player1, obstaculos)) {
                        player1.setX(player1.getX() - velocidad);
                    }else {
                        player1.setX(player1.getX() + velocidad*2      );
                    }

                }
                if (spacePressed.get()) {
                    if (!wPressed.get() && !aPressed.get() && !dPressed.get() && !sPressed.get()) {
                        Bomba bomba = new Bomba("bomba");
                        bomba.run(player1,tablero);
                    }
                }
                if (enterPressed.get()) {
                    if (!upPressed.get() && !leftPressed.get() && !rightPressed.get() && !downPressed.get()) {
                        Bomba bomba = new Bomba("bomba");
                        bomba.run(player2,tablero);
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




}
