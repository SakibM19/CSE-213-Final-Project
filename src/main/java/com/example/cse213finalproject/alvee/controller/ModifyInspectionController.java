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

public class ModifyInspectionController
{
    @javafx.fxml.FXML
    private ComboBox<String> cleaningStatusComboBox;
    @javafx.fxml.FXML
    private TextField damagesTextField;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField fuelLevelTextField;
    @javafx.fxml.FXML
    private TextField inspectionIdTextField;
    @javafx.fxml.FXML
    private TextField extraNoteTextField;
    private List<Inspection> inspectionList;
    private Inspector i;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Available", "Not Available");
        cleaningStatusComboBox.getItems().addAll("Yes", "No");

        File inspectionFile = new File("data/alvee/inspection.bin");
        this.inspectionList = BinaryFileHelper.readAllObjects(inspectionFile);

        this.i = SessionManager.getLoggedInInspector();
    }

    @javafx.fxml.FXML
    public void handleSubmitButtonOnClick(ActionEvent actionEvent) {
        List<Inspection> modifiedInspection = i.modifyInspection(inspectionIdTextField.getText(), cleaningStatusComboBox.getValue(), damagesTextField.getText(), statusComboBox.getValue(), Float.parseFloat(fuelLevelTextField.getText()), extraNoteTextField.getText(), inspectionList);
        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspection.bin"), modifiedInspection);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }
}