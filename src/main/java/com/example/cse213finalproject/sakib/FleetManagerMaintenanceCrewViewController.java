package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class FleetManagerMaintenanceCrewViewController
{
    @javafx.fxml.FXML
    private TableView blockedVehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn maintenanceTypeTableView;
    @javafx.fxml.FXML
    private TableColumn vehicleTypeTableView11;
    @javafx.fxml.FXML
    private TableColumn crewNameTableView;
    @javafx.fxml.FXML
    private TableColumn assignedVehicleIdTableView;
    @javafx.fxml.FXML
    private TableColumn expCompletionDateTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
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