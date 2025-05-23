package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.EmergencyAssistance;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.scene.control.*;


import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CustomerMedicalAssistanceViewController
{
    @javafx.fxml.FXML
    private TextField additionalInformationTextField;
    @javafx.fxml.FXML
    private RadioButton injuryRadioButton;
    @javafx.fxml.FXML
    private TextField immediatelocationTextField;
    @javafx.fxml.FXML
    private RadioButton medicalConditonRadioButton;
    @javafx.fxml.FXML
    private RadioButton otherIssueRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup emergencyType;

    private File assistanceFile = new File("data/sakib/emergency.bin");

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitMedicalAssistanceRequestOnMouseClickedButton(Event event) {
        String location = immediatelocationTextField.getText();
        String customerMessage = additionalInformationTextField.getText();

        RadioButton selectedRadioButton = (RadioButton) emergencyType.getSelectedToggle();
        String assistanceType = selectedRadioButton.getText();

        EmergencyAssistance assistance = new EmergencyAssistance(assistanceType, location, customerMessage);

        BinaryFileHelper.saveObject(assistanceFile,assistance);



        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Medical Assistance Request Sent.");
        a.showAndWait();

    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/customerEmergencyAssistanceView.fxml", event);
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