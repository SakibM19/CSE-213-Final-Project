package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class FleetManagerScheduleMaintenanceViewController
{
    @javafx.fxml.FXML
    private CheckBox routineCheckupCheckBox;
    @javafx.fxml.FXML
    private TableView blockedVehicleListTableView;
    @javafx.fxml.FXML
    private CheckBox cleaningCheckBox;
    @javafx.fxml.FXML
    private TableColumn maintenanceTypeTableView;
    @javafx.fxml.FXML
    private TableColumn blockedVehicleIdTableView;
    @javafx.fxml.FXML
    private CheckBox oilChangeCheckBox;
    @javafx.fxml.FXML
    private CheckBox tireReplacementCheckBox;
    @javafx.fxml.FXML
    private TextField enterVehicleIdTextField;
    @javafx.fxml.FXML
    private ComboBox selectCrewComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void assignOnMouseClickedButton(Event event) {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void checkOnVehicleAndCrewOnMouseClickedButton(Event event) {
    }

    @javafx.fxml.FXML
    public void refreshOnMouseClickedButton(Event event) {
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