package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FleetManagerTrackVehicleStatusViewController {

    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> listVehicleTypeTableView;
    @javafx.fxml.FXML
    private TableView<Vehicle> fleetVehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> fleetVehicleIdTableView;
    @javafx.fxml.FXML
    private TextField vehicleIdForTrackingTableView;
    @javafx.fxml.FXML
    private Label vehicleIDLabel;
    @javafx.fxml.FXML
    private Label statusLabel;

    private final File vehicleFile = new File("data/sakib/fleet.bin");
    @FXML
    private Label typeILabel;
    @FXML
    private Label brandLabel;

    @javafx.fxml.FXML
    public void initialize() {
        fleetVehicleIdTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        listVehicleTypeTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));

        loadVehicleData();
    }

    private void loadVehicleData() {
        List<Vehicle> vehicles = BinaryFileHelper.readAllObjects(vehicleFile);
        fleetVehicleListTableView.getItems().clear();
        fleetVehicleListTableView.getItems().addAll(vehicles);
    }

    @javafx.fxml.FXML
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

    @FXML
    public void trackOnMouseClickedButton(Event event) {
        String enteredVehicleId = vehicleIdForTrackingTableView.getText();

        if (enteredVehicleId.isEmpty()) {
            vehicleIDLabel.setText("Enter a Vehicle ID");
            statusLabel.setText("NA");
            return;
        }

        List<Vehicle> vehicles = BinaryFileHelper.readAllObjects(vehicleFile);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID().equalsIgnoreCase(enteredVehicleId)) {
                vehicleIDLabel.setText(vehicle.getVehicleID());
                statusLabel.setText(vehicle.getStatus());
                brandLabel.setText(vehicle.getBrand());
                typeILabel.setText(vehicle.getVehicleType());
                return;
            }
        }

        // If not found
        vehicleIDLabel.setText("Vehicle not found");
        statusLabel.setText("NA");
    }

}
