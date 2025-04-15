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

    static void switchScene(String fxmlFile, Event event) {
        if (fxmlFile == null || event == null) {
            throw new IllegalArgumentException("FXML file or event cannot be null");
        }

        try {
            URL url = SceneSwitch.class.getResource(fxmlFile);
            if (url == null) {
                throw new IllegalArgumentException("FXML file not found: " + fxmlFile);
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException | ClassCastException | IllegalArgumentException e) {
            e.printStackTrace();
            // Handle specific exceptions or log them appropriately
        }
    }
}
