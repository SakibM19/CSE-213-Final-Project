package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;

public class SendQueryController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField queryTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label ResponseLabel;
    @javafx.fxml.FXML
    private TextField querySubTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSendButtonOnClick(ActionEvent actionEvent) {
//        String requestId, String customerName, String querySub, String queryDescription
        CustomerQuery newQuery = new CustomerQuery(
                idTextField.getText(),
                nameTextField.getText(),
                querySubTextField.getText(),
                queryTextField.getText()
        );
        File file = new File("data/alvee/customer-query.bin");
        BinaryFileHelper.saveObject(file, newQuery);
    }
}