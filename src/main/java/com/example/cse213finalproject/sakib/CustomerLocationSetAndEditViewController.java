package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.Event;
import javafx.scene.control.*;


import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerLocationSetAndEditViewController
{
    @javafx.fxml.FXML
    private RadioButton dropoffLocationRadioButton;
    @javafx.fxml.FXML
    private RadioButton pickupLocationRadioButton;
    @javafx.fxml.FXML
    private Label dropoffLocationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> divisionComboBox;
    @javafx.fxml.FXML
    private Label pickupLocationLabel;
    @javafx.fxml.FXML
    private TextField regionTextfield;
    @javafx.fxml.FXML
    private ToggleGroup locationSet;

    @javafx.fxml.FXML
    public void initialize() {
        divisionComboBox.getItems().addAll("Barishal", "Chattogram", "Dhaka", "Khulna", "Rajshahi", "Rangpur", "Mymensingh", "Sylhet");
        Customer current = SessionManager.getLoggedInCustomer();
        pickupLocationLabel.setText(current.getPickUpLocation());
        dropoffLocationLabel.setText(current.getDropOffLocation());
    }

    @javafx.fxml.FXML
    public void setNewLocationOnMouseClickedButton(Event event) {
        Customer current = SessionManager.getLoggedInCustomer();

        RadioButton selectedLocation = (RadioButton) locationSet.getSelectedToggle();
        String division = divisionComboBox.getValue();
        String region = "";

        region = regionTextfield.getText();

        String fullLocation = division + ", " + region;

        if (selectedLocation.equals(pickupLocationRadioButton)) {
            current.setPickUpLocation(fullLocation);
            pickupLocationLabel.setText(fullLocation);


        } else if (selectedLocation.equals(dropoffLocationRadioButton)) {
            current.setDropOffLocation(fullLocation);
            dropoffLocationLabel.setText(fullLocation);

        }



        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Location Updated.");
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/customerDashboardView.fxml", event);
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