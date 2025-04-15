package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerCurrentBookingStatusViewController
{
    @javafx.fxml.FXML
    private Label currentStatusLabel;
    @javafx.fxml.FXML
    private Label vehicleTypeLabel;
    @javafx.fxml.FXML
    private Label dropoffTimeLabel;
    @javafx.fxml.FXML
    private Label dropoffDateLabel;
    @javafx.fxml.FXML
    private Label pickupDateLabel;
    @javafx.fxml.FXML
    private Label totalCostLabel;
    @javafx.fxml.FXML
    private Label bookingIdLabel;
    @javafx.fxml.FXML
    private Label pickupTimeLabel;
    @javafx.fxml.FXML
    private Label vehicleIdLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void cancelBookingOnMouseClickedButton(Event event) {
    }

    @javafx.fxml.FXML
    public void placeOrderOfBookingOnMouseClickedButton(Event event) {
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