package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Maintenance;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FleetManagerScheduleMaintenanceViewController
{
    @javafx.fxml.FXML
    private CheckBox routineCheckupCheckBox;
    @javafx.fxml.FXML
    private TableView<Vehicle> blockedVehicleListTableView;
    @javafx.fxml.FXML
    private CheckBox cleaningCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> blockedVehicleIdTableView;
    @javafx.fxml.FXML
    private CheckBox oilChangeCheckBox;
    @javafx.fxml.FXML
    private CheckBox tireReplacementCheckBox;
    @javafx.fxml.FXML
    private TextField enterVehicleIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String > selectCrewComboBox;

    @javafx.fxml.FXML
    private DatePicker completeDatePicker;

    File maintenanceFile = new File("data/sakib/maintenance.bin");

    File vehicleFile = new File("data/sakib/fleet.bin");

    @javafx.fxml.FXML
    public void initialize() {
        selectCrewComboBox.getItems().addAll("Crew 1","Crew 2","Crew 3","Crew 4");

        blockedVehicleIdTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        loadVehicleData();

    }

    private void loadVehicleData() {
        List<Vehicle> vehicles = BinaryFileHelper.readAllObjects(vehicleFile);

        blockedVehicleListTableView.getItems().clear();

        for (Vehicle v : vehicles) {
            if ("Under Maintenance".equalsIgnoreCase(v.getStatus())) {
                blockedVehicleListTableView.getItems().add(v);
            }
        }
    }

    @javafx.fxml.FXML
    public void assignOnMouseClickedButton(Event event) {
        String vehicleID = enterVehicleIdTextField.getText();
        String crewNo = selectCrewComboBox.getValue();
        LocalDate expCompleteDate = completeDatePicker.getValue();
        String maintenanceType = "";

        if (routineCheckupCheckBox.isSelected()) {
            maintenanceType += "Task 1: Routine Checkup";
        }

        if (cleaningCheckBox.isSelected()) {
            if (!maintenanceType.isEmpty()) maintenanceType += ", ";
            maintenanceType += "Task 2: Cleaning";
        }

        if (oilChangeCheckBox.isSelected()) {
            if (!maintenanceType.isEmpty()) maintenanceType += ", ";
            maintenanceType += "Task 3: Oil Change";
        }

        if (tireReplacementCheckBox.isSelected()) {
            if (!maintenanceType.isEmpty()) maintenanceType += ", ";
            maintenanceType += "Task 4: Tire Replacement";
        }

        Maintenance maintenance = new Maintenance(vehicleID, crewNo, maintenanceType, expCompleteDate);
        BinaryFileHelper.saveObject(maintenanceFile, maintenance);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Maintenance Crew Assigned");
        a.showAndWait();

    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void checkOnVehicleAndCrewOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerMaintenanceCrewView.fxml", event);
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