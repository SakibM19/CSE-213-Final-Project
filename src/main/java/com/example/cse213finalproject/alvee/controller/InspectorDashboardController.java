package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Inspector;
import com.example.cse213finalproject.util.SceneSwitcher;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class InspectorDashboardController
{
    @javafx.fxml.FXML
    private Text csrName;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void handleLogInspectionOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "car-for-log-inspection.fxml", "Log Inspection");
    }

    @Deprecated
    public void handleCancelBookingButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleConfirmBookingOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleReservationChangeOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspection-list.fxml", "Inspections");
    }

    @javafx.fxml.FXML
    public void handleOrderListButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleViewInspectionOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspection-list.fxml", "Inspections");
    }

    public void setLoggedInCSR(Inspector ins) {
    }

    @javafx.fxml.FXML
    public void handleChangeVehicleStatusOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "car-list.fxml", "Vehicles");
    }
}