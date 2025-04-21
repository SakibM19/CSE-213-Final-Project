package com.example.cse213finalproject.shibli;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CorporateTravelerController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button newBookingButton;

    @FXML
    private void initialize() {
        welcomeLabel.setText("Welcome, Corporate Traveler!");
    }

    @FXML
    private void handleNewBooking() {
        System.out.println("New group booking triggered.");
    }
}
