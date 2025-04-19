package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CsrInteractionHistory;
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

public class CsrInteractionHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<CsrInteractionHistory, String> interactionTypeCol;
    @javafx.fxml.FXML
    private TableColumn<CsrInteractionHistory, LocalDate> dateCol;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private TableView<CsrInteractionHistory> historyTableView;
    @javafx.fxml.FXML
    private TableColumn<CsrInteractionHistory, String> historyIdCol;
    private List<CsrInteractionHistory> csrInteractionHistoryList;

    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Reply Query", "Modify Booking" , "Cancel Booking");
        historyIdCol.setCellValueFactory(new PropertyValueFactory<>("historyId"));
        interactionTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        File historyFile = new File("data/alvee/csr-interaction-history.bin");
        this.csrInteractionHistoryList = BinaryFileHelper.readAllObjects(historyFile);

        for (CsrInteractionHistory ih: csrInteractionHistoryList){
            if (ih.getCsrId().equals(SessionManager.getLoggedInCSR().getEmployeeID())){
                historyTableView.getItems().add(ih);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "csr-dashboard.fxml", "CSR Dashboard");
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        historyTableView.getItems().clear();
        for (CsrInteractionHistory ih: csrInteractionHistoryList){
            if (typeComboBox.getValue().equals(ih.getType()) && ih.getCsrId().equals(SessionManager.getLoggedInCSR().getEmployeeID())){
                historyTableView.getItems().add(ih);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleDeleteHistoryButton(ActionEvent actionEvent) {
        csrInteractionHistoryList.removeIf(ih -> ih.getCsrId().equals(SessionManager.getLoggedInCSR().getEmployeeID()));
        BinaryFileHelper.writeAllObjects(new File("data/alvee/csr-interaction-history.bin"), csrInteractionHistoryList);
        historyTableView.getItems().clear();
    }
}