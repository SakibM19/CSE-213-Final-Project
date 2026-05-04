package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CsrInteractionHistory;
import com.example.cse213finalproject.alvee.model.InspectionHistory;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class CsrInteractionHistoryController {
    @FXML private TableColumn<CsrInteractionHistory, String> interactionTypeCol;
    @FXML private TableColumn<CsrInteractionHistory, LocalDate> dateCol;
    @FXML private ComboBox<String> typeComboBox;
    @FXML private TableView<CsrInteractionHistory> historyTableView;
    @FXML private TableColumn<CsrInteractionHistory, String> historyIdCol;

    private List<CsrInteractionHistory> csrInteractionHistoryList;
    private final File historyFile = new File("data/alvee/csr-interaction-history.bin");

    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Reply Query", "Modify Booking", "Cancel Booking");

        historyIdCol.setCellValueFactory(new PropertyValueFactory<>("historyId"));
        interactionTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        csrInteractionHistoryList = BinaryFileHelper.readAllObjects(historyFile);
        String currentCsrId = SessionManager.getLoggedInCSR().getEmployeeID();

        historyTableView.getItems().setAll(
                CsrInteractionHistory.filterByCsrId(csrInteractionHistoryList, currentCsrId)
        );
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "csr-dashboard.fxml", "CSR Dashboard");
    }

    @FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        String selectedType = typeComboBox.getValue();
        String currentCsrId = SessionManager.getLoggedInCSR().getEmployeeID();

        historyTableView.getItems().setAll(
                CsrInteractionHistory.filterByTypeAndCsrId(csrInteractionHistoryList, selectedType, currentCsrId)
        );
    }

    @FXML
    public void handleDeleteHistoryButton(ActionEvent actionEvent) {
        String currentCsrId = SessionManager.getLoggedInCSR().getEmployeeID();
        csrInteractionHistoryList = CsrInteractionHistory.removeByCsrId(csrInteractionHistoryList, currentCsrId);

        BinaryFileHelper.writeAllObjects(historyFile, csrInteractionHistoryList);
        historyTableView.getItems().clear();
    }
}
