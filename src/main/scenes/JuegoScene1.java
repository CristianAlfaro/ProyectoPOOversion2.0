package main.scenes;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.Jugadores.elecciondePersonajes;

import java.util.ArrayList;

public class JuegoScene1 extends Scene {

    Scene cambiar;
    public static int i = -1;
    public static int i2 = -1;
    ImageView player1 = new ImageView();
    ImageView player2 = new ImageView();

    public static String player1eleccion;
    public static  String player2eleccion;

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


    public JuegoScene1(Parent root) {
        super(root);

        GridPane tablero = (GridPane) lookup("#seleccion");

        ImageView eleccionplayer1 = (ImageView) lookup("#eleccionplayer1");
        ImageView eleccionplayer2 = (ImageView) lookup("#eleccionplayer2");


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


                    if (upPressed.get()) {

                        if (i2 <= 4) {
                            i2 += 5;
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            i2 -= 5;
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    if (downPressed.get()) {
                        if (i2 <= 4) {
                            i2 += 5;
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            i2 -= 5;
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }


                    if (rightPressed.get()) {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (i2 < 9) {
                            i2 += 1;
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                        }else {
                            i2 = 0;
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                        }
                    }

                    if (leftPressed.get()) {
                        i2 -= 1;
                        if (!(i2 <= -1)) {
                            player2 = (ImageView) tablero.getChildren().get(i2);
                            eleccionplayer2.setImage(player2.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            i2 = 10;
                        }
                    }
                    if (wPressed.get()) {
                        if (i <= 4) {
                            i += 5;
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            i -= 5;
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (sPressed.get()) {
                        if (i <= 4) {
                            i += 5;
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            i -= 5;
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (dPressed.get()) {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (i < 9) {
                            i += 1;
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                        }else {
                            i = 0;
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                        }
                    }
                    if (aPressed.get()) {
                        i -= 1;
                        if (!(i <= -1)) {
                            player1 = (ImageView) tablero.getChildren().get(i);
                            eleccionplayer1.setImage(player1.getImage());
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            i = 10;
                        }

                    }
                    if (spacePressed.get()) {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        elecciondePersonajes personajes = new elecciondePersonajes();
                        player1eleccion = player1.getId();
                        System.out.println(player1eleccion);
                    }
                    if (enterPressed.get()) {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        player2eleccion = player2.getId();
                        System.out.println(player2eleccion);
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
    }


