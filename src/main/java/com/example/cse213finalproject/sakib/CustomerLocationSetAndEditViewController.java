package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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

public class CustomerLocationSetAndEditViewController
{
    @javafx.fxml.FXML
    private RadioButton dropoffLocationRadioButton;
    @javafx.fxml.FXML
    private TextField additionalCommentTextField;
    @javafx.fxml.FXML
    private RadioButton pickupLocationRadioButton;
    @javafx.fxml.FXML
    private ComboBox regionComboBox;
    @javafx.fxml.FXML
    private Label dropoffLocationLabel;
    @javafx.fxml.FXML
    private ComboBox divisionComboBox;
    @javafx.fxml.FXML
    private Label pickupLocationLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void setNewLocationOnMouseClickedButton(Event event) {
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
}