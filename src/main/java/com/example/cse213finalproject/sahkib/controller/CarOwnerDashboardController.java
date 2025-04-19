package com.example.cse213finalproject.sahkib.controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CarOwnerDashboardController
{

    @javafx.fxml.FXML
    public void initialize() {
    }


    @Deprecated
    public void rentListAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerCarListView.fxml", event);
    }

    @Deprecated
    public void addCarAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerAddCarView.fxml", event);
    }

    @javafx.fxml.FXML
    public void updateCarAction(Event event) {
    }

    @javafx.fxml.FXML
    public void removeCatAction(Event event) {
    }

    @javafx.fxml.FXML
    public void rentalStatusAction(Event event) {
    }

    @javafx.fxml.FXML
    public void earningAction(Event event) {
    }

    @javafx.fxml.FXML
    public void requestMaintainenceAction(Event event) {
    }

    @javafx.fxml.FXML
    public void maintainenceHistoryAction(Event event) {
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