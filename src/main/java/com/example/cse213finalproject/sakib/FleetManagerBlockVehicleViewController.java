package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FleetManagerBlockVehicleViewController
{
    @javafx.fxml.FXML
    private DatePicker expectedUnblockingDatePicker;
    @javafx.fxml.FXML
    private TableColumn expUnblockingDateTableView;
    @javafx.fxml.FXML
    private TableColumn listVehicleTypeTableView;
    @javafx.fxml.FXML
    private TableView fleetVehicleStatusListTableView;
    @javafx.fxml.FXML
    private TableColumn listVehicleStatusTableView;
    @javafx.fxml.FXML
    private TableColumn fleetVehicleIdTableView;
    @javafx.fxml.FXML
    private ComboBox reasonForBlockingComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
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
}