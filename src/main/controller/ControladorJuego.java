package main.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Jugadores.Jugador1;
import main.Jugadores.Jugador2;
import main.Jugadores.Jugadores;
import main.mainApp;
import main.scenes.FactoryScene;
import main.scenes.TypeScene;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorJuego implements Initializable {

    double x = 0;
    double y = 0;
    @FXML private ImageView player1;
    @FXML private ImageView player2;





    @FXML private ImageView link;
    @FXML private AnchorPane fondojuego;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


