package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Inspection;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.util.List;

public class InspectionListController
{
    @javafx.fxml.FXML
    private TableColumn<Inspection, Double> fuelLevelCol;
    @javafx.fxml.FXML
    private TableView<Inspection> inspectionTableView;
    @javafx.fxml.FXML
    private TableColumn<Inspection, String> cleaningStatusCol;
    @javafx.fxml.FXML
    private TableColumn<Inspection, String> inspectionIdCol;
    @javafx.fxml.FXML
    private TableColumn<Inspection, String> vehicleStatusCol;
    @javafx.fxml.FXML
    private TableColumn<Inspection, String> vehicleIdCol;
    @javafx.fxml.FXML
    private TableColumn<Inspection, String> inspectionStatusCol;

    @javafx.fxml.FXML
    public void initialize() {
        vehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("carId"));
        cleaningStatusCol.setCellValueFactory(new PropertyValueFactory<>("isClean"));
        inspectionIdCol.setCellValueFactory(new PropertyValueFactory<>("inspectionId"));
        fuelLevelCol.setCellValueFactory(new PropertyValueFactory<>("fuelLevel"));
        vehicleStatusCol.setCellValueFactory(new PropertyValueFactory<>("isAvailableAfterInspection"));
        inspectionStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        File file = new File("data/alvee/inspection.bin");
        List<Inspection> inspectionList = BinaryFileHelper.readAllObjects(file);

        inspectionTableView.getItems().addAll(inspectionList);

    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }
}