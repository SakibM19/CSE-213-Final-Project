package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ReservationCancelationController
{
    @javafx.fxml.FXML
    private Text carNameText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private TextField bookingIdTextField;
    @javafx.fxml.FXML
    private Text customerNameText;
    @javafx.fxml.FXML
    private Text endDateText;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCancelBookingButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "csr-dashboard.fxml", "Dashboard");
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
    }
}