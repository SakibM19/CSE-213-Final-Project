package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.List;

public class MakeIsAvailableController
{
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField carIdTextField;
    private List<Vehicle> vehicleList;
    private Vehicle v;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Available", "Not Available");

        File vehicleFile = new File("data/sakib/fleet.bin");
        this.vehicleList = BinaryFileHelper.readAllObjects(vehicleFile);
    }

    @javafx.fxml.FXML
    public void handleSaveButtonOnClick(ActionEvent actionEvent) {
        for (Vehicle v: vehicleList){
            if (carIdTextField.getText().equals(v.getVehicleID())){
                this.v = v;
                break;
            }
        }

        this.v.setStatus(statusComboBox.getValue());

        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getVehicleID().equals(v.getVehicleID())) {
                vehicleList.set(i, v);
                break;
            }
        }

        BinaryFileHelper.writeAllObjects(new File("data/sakib/fleet.bin"), vehicleList);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "car-list.fxml", "Vehicles");
    }
}