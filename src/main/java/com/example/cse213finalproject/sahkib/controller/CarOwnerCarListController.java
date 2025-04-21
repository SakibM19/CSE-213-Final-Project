package com.example.cse213finalproject.sahkib.controller;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CarOwnerCarListController
{

    @FXML
    private ComboBox chooseVehicleComboBox1;
    @FXML
    private ComboBox chooseVehicleComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void backAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerDashboardView.fxml", event);
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