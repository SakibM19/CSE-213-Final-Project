package com.example.cse213finalproject.sahkib.controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ChauffeurServiceUserBookingController {
    @javafx.fxml.FXML
    private ComboBox chooseVehicleComboBox1;
    @javafx.fxml.FXML
    private ComboBox chooseVehicleComboBox;

    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserDashBoardView.fxml", event);
    }
    private void switchScene(String fxmlFile, Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
