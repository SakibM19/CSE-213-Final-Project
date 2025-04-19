package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Inspection;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.List;

public class InspectionStatusChangeController
{
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField inspectionIdTextField;
    private List<Inspection> inspectionList;
    private Inspection ins;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Done", "Pending");

        File inspectionFile = new File("data/alvee/inspection.bin");
        this.inspectionList = BinaryFileHelper.readAllObjects(inspectionFile);
    }

    @javafx.fxml.FXML
    public void handleSaveButtonOnClick(ActionEvent actionEvent) {
        for (Inspection ins: inspectionList){
            if (inspectionIdTextField.getText().equals(ins.getInspectionId())){
                this.ins = ins;
                break;
            }
        }

        this.ins.setStatus(statusComboBox.getValue());

        for (int i = 0; i < inspectionList.size(); i++) {
            if (inspectionList.get(i).getInspectionId().equals(ins.getInspectionId())) {
                inspectionList.set(i, ins);
                break;
            }
        }

        BinaryFileHelper.writeAllObjects(new File("data/alvee/inspection.bin"), inspectionList);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "inspector-dashboard.fxml", "Inspector Dashboard");
    }
}