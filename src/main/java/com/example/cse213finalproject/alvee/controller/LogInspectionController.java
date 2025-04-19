package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Inspection;
import com.example.cse213finalproject.alvee.model.Inspector;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.List;

public class LogInspectionController {
    @javafx.fxml.FXML
    private ComboBox<String> cleaningStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField vehicleIdTextField;
    @javafx.fxml.FXML
    private TextField fuelLevelTextField;
    @javafx.fxml.FXML
    private TextField extraNoteTextField;
    private List<Inspection> inspectionList;
    private Inspector i;
    @javafx.fxml.FXML
    private TextField damagesTextField;
    private List<Vehicle> vehicleList;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Available", "Not Available");
        cleaningStatusComboBox.getItems().addAll("Yes", "No");

        File inspectionFile = new File("data/alvee/inspection.bin");
        this.inspectionList = BinaryFileHelper.readAllObjects(inspectionFile);

        File vehicleFile = new File("data/sakib/fleet.bin");
        this.vehicleList = BinaryFileHelper.readAllObjects(vehicleFile);

        this.i = SessionManager.getLoggedInInspector();
    }

    @javafx.fxml.FXML
    public void handleSubmitButtonOnClick(ActionEvent actionEvent) {
        boolean isVehicle = false;
        for (Vehicle v : vehicleList) {
            if (v.getVehicleID().equals(vehicleIdTextField.getText())) {
                isVehicle = true;
                break;
            }
        }
//        String vehicleId, String damages, double fuelLevel, boolean cleaningStatus, boolean isAvailable, String extraNote
        if (!isVehicle) {
            return;
        }


        Inspection localInspection = i.logInspection(
                vehicleIdTextField.getText(),
                damagesTextField.getText(),
                Float.parseFloat(fuelLevelTextField.getText()),
                cleaningStatusComboBox.getValue(),
                statusComboBox.getValue(),
                extraNoteTextField.getText()
        );
        localInspection.setIsAvailableAfterInspection("Not Available");

        inspectionList.add(localInspection);
        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspection.bin"), inspectionList);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "car-for-log-inspection.fxml", "Log Inspection");
    }
}