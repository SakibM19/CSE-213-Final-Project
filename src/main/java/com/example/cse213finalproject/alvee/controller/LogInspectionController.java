// Refactored LogInspectionController
package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Inspection;
import com.example.cse213finalproject.alvee.model.Inspector;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.util.List;

public class LogInspectionController {
    @javafx.fxml.FXML
    private ComboBox<String> cleaningStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField vehicleIdTextField;
    @javafx.fxml.FXML
    private TextField fuelLevelTextField;
    @javafx.fxml.FXML
    private TextField extraNoteTextField;
    private List<Inspection> inspectionList;
    private Inspector inspector;
    @javafx.fxml.FXML
    private TextField damagesTextField;
    private List<Vehicle> vehicleList;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Available", "Not Available");
        cleaningStatusComboBox.getItems().addAll("Yes", "No");

        this.inspectionList = BinaryFileHelper.readAllObjects(new File("data/alvee/inspection.bin"));
        this.vehicleList = BinaryFileHelper.readAllObjects(new File("data/sakib/fleet.bin"));
        this.inspector = SessionManager.getLoggedInInspector();
    }

    @javafx.fxml.FXML
    public void handleSubmitButtonOnClick(ActionEvent actionEvent) {
        String vehicleId = vehicleIdTextField.getText().trim();
        String damages = damagesTextField.getText().trim();
        String fuelText = fuelLevelTextField.getText().trim();
        String cleaningStatus = cleaningStatusComboBox.getValue();
        String availability = statusComboBox.getValue();
        String extraNote = extraNoteTextField.getText().trim();

        if (vehicleId.isEmpty() || damages.isEmpty() || fuelText.isEmpty() || cleaningStatus == null || availability == null) {
            showAlert("Please fill out all required fields.");
            return;
        }

        double fuelLevel;
        try {
            fuelLevel = Double.parseDouble(fuelText);
            if (fuelLevel < 0 || fuelLevel > 100) {
                showAlert("Fuel level must be between 0 and 100.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Fuel level must be a valid number.");
            return;
        }

        boolean vehicleExists = vehicleList.stream().anyMatch(v -> v.getVehicleID().equals(vehicleId));
        if (!vehicleExists) {
            showAlert("Vehicle ID does not exist in the system.");
            return;
        }

        Inspection newInspection = inspector.logInspection(
                vehicleId,
                damages,
                fuelLevel,
                cleaningStatus,
                availability,
                extraNote
        );

        inspectionList.add(newInspection);
        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspection.bin"), inspectionList);

        showAlert("Inspection logged successfully!", AlertType.INFORMATION);
        clearForm();
    }

    private void showAlert(String message) {
        showAlert(message, AlertType.WARNING);
    }

    private void showAlert(String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        vehicleIdTextField.clear();
        damagesTextField.clear();
        fuelLevelTextField.clear();
        extraNoteTextField.clear();
        cleaningStatusComboBox.setValue(null);
        statusComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "car-for-log-inspection.fxml", "Log Inspection");
    }
}
