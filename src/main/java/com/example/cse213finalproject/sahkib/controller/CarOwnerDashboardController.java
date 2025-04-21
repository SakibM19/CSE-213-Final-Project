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
    private Text csrName;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void rentListAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerCarListView.fxml", event);
    }

    @javafx.fxml.FXML
    public void addCarAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerAddCarView.fxml", event);
    }

    @javafx.fxml.FXML
    public void updateCarAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerUpdateCarView.fxml", event);
    }

    @javafx.fxml.FXML
    public void removeCatAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerRemoveCarView.fxml", event);
    }

    @javafx.fxml.FXML
    public void rentalStatusAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerRentalStatusView.fxml", event);
    }

    @javafx.fxml.FXML
    public void earningAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerEarningsView.fxml", event);
    }

    @javafx.fxml.FXML
    public void requestMaintainenceAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerRequestMaintainanceView.fxml", event);
    }

    @javafx.fxml.FXML
    public void maintainenceHistoryAction(Event event) {
        switchScene("/com/example/cse213finalproject/sahkib/CarOwnerMaintainanceHistoryView.fxml", event);
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