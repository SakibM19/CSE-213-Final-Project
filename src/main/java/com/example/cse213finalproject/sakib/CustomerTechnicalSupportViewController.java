package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.EmergencyAssistance;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CustomerTechnicalSupportViewController {
    @javafx.fxml.FXML
    private RadioButton otherIssuesRadioButton;
    @javafx.fxml.FXML
    private TextField additionalInformationTextField;
    @javafx.fxml.FXML
    private TextField immediatelocationTextField;
    @javafx.fxml.FXML
    private RadioButton vehicleBreakdownRadioButton;
    @javafx.fxml.FXML
    private RadioButton accidentOrCollisionRadioButton;
    @javafx.fxml.FXML
    private RadioButton flatTireRadioButton;
    @javafx.fxml.FXML
    private RadioButton batteryIssueRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup isssueType;

    private File assistanceFile = new File("data/sakib/emergency.bin");

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitAssistanceRequestOnMouseClickedButton(Event event) {
        String location = immediatelocationTextField.getText();
        String customerMessage = additionalInformationTextField.getText();

        // Get the selected radio button from the ToggleGroup
        RadioButton selectedRadioButton = (RadioButton) isssueType.getSelectedToggle();
        String assistanceType = selectedRadioButton != null ? selectedRadioButton.getText() : "Other";

        // Create an EmergencyAssistance object and save it
        EmergencyAssistance assistance = new EmergencyAssistance(assistanceType, location, customerMessage);
        BinaryFileHelper.saveObject(assistanceFile, assistance);

        // Show confirmation message
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Emergency Assistance Request Sent.");
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
