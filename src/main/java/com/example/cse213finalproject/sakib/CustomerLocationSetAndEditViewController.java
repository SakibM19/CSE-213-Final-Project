package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
    }
}