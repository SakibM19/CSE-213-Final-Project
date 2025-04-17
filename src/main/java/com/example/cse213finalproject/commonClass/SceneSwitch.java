package com.example.cse213finalproject.commonClass;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public interface SceneSwitch {

     public static void switchScene(String fxmlFile, Event event) {
        try {
            FXMLLoader Loader = new FXMLLoader(SceneSwitch.class.getResource(fxmlFile));
            Parent root = Loader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
