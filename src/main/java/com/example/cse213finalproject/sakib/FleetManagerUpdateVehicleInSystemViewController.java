package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FleetManagerUpdateVehicleInSystemViewController{
    @javafx.fxml.FXML
    private TextField vehicleBrandTextField;
    @javafx.fxml.FXML
    private TextField perDayCostTextfield;
    @javafx.fxml.FXML
    private TextField vehicleModelTextField;
    @javafx.fxml.FXML
    private ComboBox<String> seatCapacityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeComboBox;
    @javafx.fxml.FXML
    private TextField enterVehicleIDTextField;

    private final File vehicleFile = new File("data/sakib/fleet.bin");

    @javafx.fxml.FXML
    public void initialize() {
        seatCapacityComboBox.getItems().addAll("2", "5", "7");
        vehicleTypeComboBox.getItems().addAll("Sedan", "SUV");
    }

    @javafx.fxml.FXML
    public void addVehicleOnMouseClickedButton(Event event) {
        String id = enterVehicleIDTextField.getText();
        String model = vehicleModelTextField.getText();
        String type = vehicleTypeComboBox.getValue();
        String brand = vehicleBrandTextField.getText();
        int seat = Integer.parseInt(seatCapacityComboBox.getValue());
        float cost = Float.parseFloat(perDayCostTextfield.getText());

        Vehicle newVehicle = new Vehicle(id, model, type, brand, seat, cost);
        BinaryFileHelper.saveObject(vehicleFile, newVehicle);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Vehicle added in the fleet.");
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void removeVehicleOnMouseClickedButton(Event event) {
        String idToRemove = enterVehicleIDTextField.getText();

        List<Vehicle> vehicles = BinaryFileHelper.readAllObjects(vehicleFile);
        vehicles.removeIf(v -> v.getVehicleID().equals(idToRemove));

        BinaryFileHelper.writeAllObjects(vehicleFile, vehicles);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Vehicle removed from the fleet.");
        a.showAndWait();
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
}
