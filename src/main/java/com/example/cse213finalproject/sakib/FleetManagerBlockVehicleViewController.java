package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FleetManagerBlockVehicleViewController {
    @FXML
    private TableColumn<Vehicle, String> listVehicleTypeTableView;
    @FXML
    private TableView<Vehicle> fleetVehicleStatusListTableView;
    @FXML
    private TableColumn<Vehicle, String> listVehicleStatusTableView;
    @FXML
    private TableColumn<Vehicle, String> fleetVehicleIdTableView;
    @FXML
    private ComboBox<String> reasonForBlockingComboBox;
    private List<Vehicle> vehicleList;
    @FXML
    private TextField vehicleIDTextField;
    private Vehicle v;


//    private final ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        reasonForBlockingComboBox.getItems().setAll("Maintenance", "Inspection");


        // Bind table columns
        fleetVehicleIdTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        listVehicleTypeTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        listVehicleStatusTableView.setCellValueFactory(new PropertyValueFactory<>("status"));
        File vehicleFile = new File("data/sakib/fleet.bin");
        this.vehicleList = BinaryFileHelper.readAllObjects(vehicleFile);

//        vehicleList.clear();
        fleetVehicleStatusListTableView.getItems().addAll(vehicleList);


    }


    private void saveUpdatedVehicleData() {
        // Save the updated list back to the binary file
        File vehicleFile = new File("data/sakib/fleet.bin");
        BinaryFileHelper.writeAllObjects(vehicleFile, vehicleList);
    }


    @FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
    }

    @FXML
    public void refreshOnMouseClickedButton(Event event) {
        fleetVehicleStatusListTableView.getItems().clear();
        fleetVehicleStatusListTableView.getItems().addAll(vehicleList);
    }


    @FXML
    public void unblockVehicleOnMouseClickedButton(Event event) {
        for (Vehicle v : vehicleList) {
            if (v.getVehicleID().equals(vehicleIDTextField.getText())) {
                this.v = v;
                break;
            }
        }
        if (v != null) {
            v.setStatus("Available");
        }


        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getVehicleID().equals(v.getVehicleID())) {
                vehicleList.set(i, v);
                break;
            }
        }

        File vehicleFile = new File("data/sakib/fleet.bin");
        BinaryFileHelper.writeAllObjects(vehicleFile, vehicleList);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Vehicle Unblocked");
        a.showAndWait();


    }

    @FXML
    public void blockVehicleForMaintenanceOnMouseClickedButton(Event event) {
        for (Vehicle v : vehicleList) {
            if (v.getVehicleID().equals(vehicleIDTextField.getText())) {
                this.v = v;
                break;
            }
        }

        String status = "";
        if (reasonForBlockingComboBox.getValue().equals("Maintenance")) {
            status = "Under Maintenance";
        } else if (reasonForBlockingComboBox.getValue().equals("Inspection")) {
            status = "Under Inspection";
        }

        // Ensure a vehicle is selected and the ComboBox has a valid selection
        if (v != null && reasonForBlockingComboBox.getValue() != null) {
            v.setStatus(status);
        }

        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getVehicleID().equals(v.getVehicleID())) {
                vehicleList.set(i, v);
                break;
            }
        }

        File vehicleFile = new File("data/sakib/fleet.bin");
        BinaryFileHelper.writeAllObjects(vehicleFile, vehicleList);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Vehicle Blocked");
        a.showAndWait();

    }

    private void switchScene(String fxmlFile, Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //


}