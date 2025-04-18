package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class CustomerPlaceOrderInformationViewController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> seatsWantedComboBox;
    @javafx.fxml.FXML
    private DatePicker dropoffDatePicker;
    @javafx.fxml.FXML
    private DatePicker pickupDatePicker;
    @javafx.fxml.FXML
    private TextField dropoffLocationTextField;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeWantedComboBox;
    @javafx.fxml.FXML
    private TextField pickupLocationTextField;

    @javafx.fxml.FXML
    public void initialize() {

        seatsWantedComboBox.getItems().addAll(2, 5, 7);
        vehicleTypeWantedComboBox.getItems().addAll("Sedan","SUV");
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
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

    @javafx.fxml.FXML
    public void placeOrderOnMouseClickedButton(Event event) {

    }

    @javafx.fxml.FXML
    public void createBookingOnMouseClickedButton(Event event) {
    }

    @javafx.fxml.FXML
    public void defaultLocationOnMouseClickedButton(Event event) {
    }
}