package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class FleetManagerTrackMaintenanceViewController
{
    @javafx.fxml.FXML
    private Label vehicleTypeLabel;
    @javafx.fxml.FXML
    private Label nextMaintananceDateLabel;
    @javafx.fxml.FXML
    private Label vehicleIdLabel;
    @javafx.fxml.FXML
    private Label currentMaintananceStatusLabel;
    @javafx.fxml.FXML
    private Label lastMaintananceDateLabel;
    @javafx.fxml.FXML
    private TableColumn listVehicleTypeTableView;
    @javafx.fxml.FXML
    private TableView fleetVehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn fleetVehicleIdTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void getVehicleStatusOnMouseClickedButton(Event event) {

    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void updateVehicleStatusOnMouseClickedButton(Event event) {
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