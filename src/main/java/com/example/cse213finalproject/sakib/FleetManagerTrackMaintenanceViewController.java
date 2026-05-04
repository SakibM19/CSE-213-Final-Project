package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Maintenance;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FleetManagerTrackMaintenanceViewController {

    @FXML
    private Label vehicleIdLabel;
    @FXML
    private Label currentMaintananceStatusLabel;
    @FXML
    private TableView<Maintenance> fleetVehicleListTableView;
    @FXML
    private TableColumn<Maintenance, String> fleetVehicleIdTableView;
    @FXML
    private Label maintenanceFinishDateLabel;
    @FXML
    private Label crewLabel;
    @FXML
    private TextField vehicleIDTextField;

    private final File maintenanceFile = new File("data/sakib/maintenance.bin");

    private void loadMaintenanceData() {
        List<Maintenance> maintenanceList = BinaryFileHelper.readAllObjects(maintenanceFile);
        if (maintenanceList != null) {
            fleetVehicleListTableView.getItems().clear();
            fleetVehicleListTableView.getItems().addAll(maintenanceList);
        }
    }

    @FXML
    public void initialize() {
        fleetVehicleIdTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        loadMaintenanceData();
    }

    @FXML
    public void getVehicleStatusOnMouseClickedButton(Event event) {
        String vehicleID = vehicleIDTextField.getText().trim();

        if (vehicleID.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a vehicle ID.");
            return;
        }

        // Load the maintenance list and find the vehicle matching the ID
        List<Maintenance> maintenanceList = BinaryFileHelper.readAllObjects(maintenanceFile);
        Maintenance selectedMaintenance = null;

        if (maintenanceList != null) {
            for (Maintenance maintenance : maintenanceList) {
                if (maintenance.getVehicleID().equals(vehicleID)) {
                    selectedMaintenance = maintenance;
                    break;
                }
            }
        }

        // If the selected maintenance is found, display the details
        if (selectedMaintenance != null) {
            vehicleIdLabel.setText(selectedMaintenance.getVehicleID());
            currentMaintananceStatusLabel.setText(selectedMaintenance.getMaintenanceType());
            maintenanceFinishDateLabel.setText(selectedMaintenance.getExpCompleteDate().toString());
            crewLabel.setText(selectedMaintenance.getCrewNo());
        } else {
            // If no maintenance record is found, clear the labels
            clearLabels();
            showAlert(Alert.AlertType.ERROR, "Error", "No maintenance record found for the given vehicle ID.");
        }
    }

    @FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
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

    // Method to clear the labels if no maintenance record is found
    private void clearLabels() {
        vehicleIdLabel.setText("No vehicle selected");
        currentMaintananceStatusLabel.setText("N/A");
        maintenanceFinishDateLabel.setText("N/A");
        crewLabel.setText("N/A");
        vehicleIDTextField.clear();
    }

    // Method to show an alert message
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
