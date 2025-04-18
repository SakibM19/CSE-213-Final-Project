package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Maintenance;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FleetManagerBlockVehicleViewController
{
    @javafx.fxml.FXML
    private DatePicker expectedUnblockingDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Maintenance, LocalDate> expUnblockingDateTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance, String> listVehicleTypeTableView;
    @javafx.fxml.FXML
    private TableView<Maintenance> fleetVehicleStatusListTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance, String> listVehicleStatusTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance, String> fleetVehicleIdTableView;
    @javafx.fxml.FXML
    private ComboBox<String> reasonForBlockingComboBox;

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

    @javafx.fxml.FXML
    public void unblockVehicleOnMouseClickedButton(Event event) {
    }

    @javafx.fxml.FXML
    public void blockVehicleForMaintenanceOnMouseClickedButton(Event event) {
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