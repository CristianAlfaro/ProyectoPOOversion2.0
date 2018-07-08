package main.scenes;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.musica.reproductor;

import java.io.IOException;

public class FactoryScene {

    public static Scene getScene(TypeScene type, Application app) {
        Parent fxml;
        switch (type) {
            case JUEGUITO:
                try {
                    fxml = FXMLLoader.load(app.getClass().getResource("fxml/pantallaJuego.fxml"));
                    Scene j = new JuegoScene(fxml);
                    return j;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case MAIN:
                try {
                    fxml = FXMLLoader.load(app.getClass().getResource("fxml/pantallaInicio.fxml"));
                    return new Scene(fxml);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case SELLECCION:
                try {
                    fxml = FXMLLoader.load(app.getClass().getResource("fxml/pantallaMenu.fxml"));
                    return new JuegoScene1(fxml);
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }

        return null;
    }
}
