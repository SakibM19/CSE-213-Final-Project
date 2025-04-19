package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.InspectionHistory;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class InspectionHistoryController
{
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private TableColumn<InspectionHistory, String> inspectionIdCol;
    @javafx.fxml.FXML
    private TableView<InspectionHistory> historyTableView;
    @javafx.fxml.FXML
    private TableColumn<InspectionHistory, String> historyIdCol;
    @javafx.fxml.FXML
    private TableColumn<InspectionHistory, String> interactionTypeCol;
    private List<InspectionHistory> inspectionHistoryList;
    @javafx.fxml.FXML
    private TableColumn<InspectionHistory, LocalDate> dateCol;

    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Delete", "Modify");
        historyIdCol.setCellValueFactory(new PropertyValueFactory<>("historyId"));
        inspectionIdCol.setCellValueFactory(new PropertyValueFactory<>("inspectionId"));
        interactionTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        File historyFile = new File("data/alvee/inspectionHistory.bin");
        this.inspectionHistoryList = BinaryFileHelper.readAllObjects(historyFile);

        for (InspectionHistory ih: inspectionHistoryList){
            if (ih.getInspectorId().equals(SessionManager.getLoggedInInspector().getEmployeeID())){
                historyTableView.getItems().add(ih);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        historyTableView.getItems().clear();
        for (InspectionHistory ih: inspectionHistoryList){
            if (typeComboBox.getValue().equals(ih.getType()) && ih.getInspectorId().equals(SessionManager.getLoggedInInspector().getEmployeeID())){
                historyTableView.getItems().add(ih);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleDeleteHistoryButton(ActionEvent actionEvent) {
        inspectionHistoryList.removeIf(ih -> ih.getInspectorId().equals(SessionManager.getLoggedInInspector().getEmployeeID()));
        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspectionHistory.bin"), inspectionHistoryList);
        historyTableView.getItems().clear();
    }
}