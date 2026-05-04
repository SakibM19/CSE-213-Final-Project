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

public class CarForLogInspectionController
{
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> idCol;
    @javafx.fxml.FXML
    private TableView<Vehicle> carTableView;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> brandCol;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> modelCol;

    @javafx.fxml.FXML
    public void initialize() {
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        File file = new File("data/sakib/fleet.bin");
        List<Vehicle> vehicleList = BinaryFileHelper.readAllObjects(file);

        for (Vehicle v: vehicleList){
            if (v.getStatus().equals("Under Inspection")){
                carTableView.getItems().add(v);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleLogInspectionButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "log-inspection.fxml", "Log Inspection");
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }
}