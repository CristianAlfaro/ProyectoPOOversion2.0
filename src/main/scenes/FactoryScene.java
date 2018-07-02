package main.scenes;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class FactoryScene {

    public static Scene getScene(TypeScene type, Application app) {
        Parent fxml = null;
        switch (type) {
            case JUEGUITO:

                try {
                    fxml = FXMLLoader.load(app.getClass().getResource("fxml/pantallaJuego.fxml"));
                    return new JuegoScene(fxml);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case MAIN:
                try {
                    fxml = FXMLLoader.load(app.getClass().getResource("fxml/pantallaInicio.fxml"));
                    return new JuegoScene(fxml);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case SELLECCION:
                try {
                    fxml = FXMLLoader.load(app.getClass().getResource("fxml/pantallaMenu.fxml"));
                    return new JuegoScene(fxml);
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }

        return null;
    }
}
