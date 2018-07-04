package main.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.mainApp;
import main.scenes.FactoryScene;
import main.scenes.TypeScene;

import static java.rmi.Naming.lookup;

public class ControladorMenu {


    double x = 0;
    double y = 0;
    @FXML private ImageView eleccionplayer1;
    @FXML private ImageView linktabla;
    @FXML private ImageView zeldatabla;
    @FXML private ImageView samustabla;
    @FXML private ImageView sonictabla;
    @FXML private ImageView pikachutabla;
    @FXML private ImageView kirbytabla;
    @FXML private ImageView pacmantabla;
    @FXML private ImageView bombermatabla;
    @FXML private ImageView ashtabla;
    @FXML private ImageView gokutabla;
    @FXML private ImageView cursorP1;
    @FXML private GridPane tablero;

    ImageView player1 = cursorP1;

    @FXML private AnchorPane tienda;



    @FXML
    void dragged (MouseEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed (MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void closeWindows (MouseEvent event){
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void Jugar (MouseEvent event) throws Exception {
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e ) {
            System.out.println("Thread Interrupted");
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(FactoryScene.getScene(TypeScene.JUEGUITO,mainApp.getInstance()));

    }

    @FXML
    void store (MouseEvent event){
        tienda.setVisible(true);
    }
    @FXML
    void storeback (MouseEvent event){
        tienda.setVisible(false);
    }

    @FXML
    void elejirpersonajelink (MouseEvent event){
        System.out.println(linktabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/link.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajezelda (MouseEvent event){
        System.out.println(zeldatabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/zelda.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajesamus (MouseEvent event){
        System.out.println(samustabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/samus.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajepikachu (MouseEvent event){
        System.out.println(pikachutabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/pikachu.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajesonic (MouseEvent event){
        System.out.println(sonictabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/sonic.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajekirby (MouseEvent event){
        System.out.println(kirbytabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/kirby.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajeash (MouseEvent event){
        System.out.println(ashtabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/ash.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajegoku (MouseEvent event){
        System.out.println(gokutabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/goku.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajepacman (MouseEvent event){
        System.out.println(pacmantabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/pacman.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonajebomberman (MouseEvent event){
        System.out.println(bombermatabla.getId());
        Image image = new Image(getClass().getResourceAsStream("../images/bomberman.png"));
        eleccionplayer1.setImage(image);
    }
    @FXML
    void elejirpersonaje (MouseEvent event){

    }

}
