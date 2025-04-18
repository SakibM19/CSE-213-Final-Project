package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CsrDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCustomerQueriesOnAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/cse213finalproject/alvee/query-request-list.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Query Requests");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Optional: replace with proper alert or logging
        }
    }

    @Deprecated
    public void handlereservationChangesButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "reservation-request-list.fxml", "Reservation Changes");
    }

    @Deprecated
    public void handleCancelReservationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCancelBookingButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "reservation-cancelation.fxml", "Cancel Reservation");
    }
}