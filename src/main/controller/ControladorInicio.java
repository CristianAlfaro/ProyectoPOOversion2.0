package main.controller;


import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Jugadores.Jugador1;
import main.Jugadores.Jugador2;
import main.Jugadores.Jugadores;
import main.mainApp;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorInicio implements Initializable {

    double x = 0;
    double y = 0;
    String player1 = "";
    String player2 = "";

    Jugadores p1 = Jugador1.getInstance();
    Jugadores p2 = Jugador2.getInstance();

    @FXML private JFXTextField textplayer1;
    @FXML private JFXTextField textplayer2;
    @FXML private AnchorPane pantallatop;
    @FXML private AnchorPane patallainicio;
    @FXML private AnchorPane help;
    @FXML private AnchorPane helpp1;
    @FXML private AnchorPane helpp2;
    @FXML private AnchorPane pantallacarga;


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
    void saveplayers (MouseEvent event) throws Exception {
        player1 = textplayer1.getText();
        player2 = textplayer2.getText();
        p1.setNombre(player1);
        p2.setNombre(player2);
        System.out.println(p1.getNombre());
        System.out.println(p2.getNombre());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e ) {
            System.out.println("Thread Interrupted");
        }


        Parent parent = FXMLLoader.load(mainApp.obtenerdirrectorio().getClass().getResource("fxml/pantallaMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }
    @FXML
    void pantallaCarga (){
        pantallacarga.setVisible(true);

    }
    @FXML
    void topscore (MouseEvent event){
        pantallatop.setVisible(true);
    }
    @FXML
    void topscoreback (MouseEvent event){
        pantallatop.setVisible(false);
    }
    @FXML
    void helpuser (MouseEvent event){
        help.setVisible(true);
    }
    @FXML
    void helpuserback (MouseEvent event){
        help.setVisible(false);
    }
    @FXML
    void helpuserp1 (MouseEvent event){
        helpp1.setVisible(true);
    }
    @FXML
    void helpuserp2 (MouseEvent event){
        helpp2.setVisible(true);
    }
    @FXML
    void helpuserbackp1 (MouseEvent event){
        helpp1.setVisible(false);
    }
    @FXML
    void helpuserbackp2 (MouseEvent event){
        helpp2.setVisible(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}


