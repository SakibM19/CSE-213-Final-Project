package com.example.cse213finalproject.shibli;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RideShareDriverController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button viewPromotionsButton;

    @FXML
    private void initialize() {
        welcomeLabel.setText("Welcome, Ride-Share Driver!");
    }

    @FXML
    private void handleViewPromotions() {
        System.out.println("Promotions and rewards viewed.");
    }
}
