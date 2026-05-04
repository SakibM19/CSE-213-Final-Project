package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.util.List;

public class CarListController
{
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> brandCol;
    @javafx.fxml.FXML
    private TableView<Vehicle> vehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> vehicleIdCol;

    @javafx.fxml.FXML
    public void initialize() {
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        vehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));

        File vehicleFile = new File("data/sakib/fleet.bin");
        List<Vehicle> vehicleList = BinaryFileHelper.readAllObjects(vehicleFile);
        vehicleListTableView.getItems().addAll(vehicleList);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }

    @javafx.fxml.FXML
    public void handleAvailableOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "make-is-available.fxml", "Change Status");
    }
}