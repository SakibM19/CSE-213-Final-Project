package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Inspection;
import com.example.cse213finalproject.alvee.model.InspectionHistory;
import com.example.cse213finalproject.alvee.model.Inspector;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.OrderIdGenerator;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class DeleteInspectionController {
    @javafx.fxml.FXML
    private TextField inspectionIdTextField;
    private List<Inspection> inspectionList;
    private Inspector i;
    private List<InspectionHistory> inspectionHistoryList;

    @javafx.fxml.FXML
    public void initialize() {
        File inspectionFile = new File("data/alvee/inspection.bin");
        this.inspectionList = BinaryFileHelper.readAllObjects(inspectionFile);

        File historyFile = new File("data/alvee/inspectionHistory.bin");
        this.inspectionHistoryList = BinaryFileHelper.readAllObjects(historyFile);

        this.i = SessionManager.getLoggedInInspector();
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }

    @javafx.fxml.FXML
    public void handleDeleteButtonOnClick(ActionEvent actionEvent) {
        String inspectionId = inspectionIdTextField.getText().trim();

        if (inspectionId.isEmpty()) {
            showAlert("Please enter an inspection ID.");
            return;
        }

        boolean found = inspectionList.stream().anyMatch(ins -> ins.getInspectionId().equals(inspectionId));
        if (!found) {
            showAlert("Inspection ID not found.");
            return;
        }

        List<Inspection> newInspectionList = i.deleteInspection(inspectionId, inspectionList);
        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspection.bin"), newInspectionList);

        InspectionHistory inspectionHistory = new InspectionHistory(
                OrderIdGenerator.generateInspectionHistoryId(),
                "Delete",
                LocalDate.now(),
                inspectionId,
                i.getEmployeeID()
        );

        inspectionHistoryList.add(inspectionHistory);
        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspectionHistory.bin"), inspectionHistoryList);

        showAlert("Inspection deleted successfully!", AlertType.INFORMATION);
        inspectionIdTextField.clear();
    }

    private void showAlert(String message) {
        showAlert(message, AlertType.WARNING);
    }

    private void showAlert(String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
