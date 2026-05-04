package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import com.example.cse213finalproject.sakibModelClass.Maintenance;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FleetManagerMaintenanceCrewViewController implements SceneSwitch
{
    @javafx.fxml.FXML
    private TableView<Maintenance> blockedVehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance, String> maintenanceTypeTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance,String> crewNameTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance,String> assignedVehicleIdTableView;
    @javafx.fxml.FXML
    private TableColumn<Maintenance, LocalDate> expCompletionDateTableView;

    @javafx.fxml.FXML
    public void initialize() {
        // Bind columns to Maintenance class fields
        assignedVehicleIdTableView.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        crewNameTableView.setCellValueFactory(new PropertyValueFactory<>("crewNo"));
        maintenanceTypeTableView.setCellValueFactory(new PropertyValueFactory<>("maintenanceType"));
        expCompletionDateTableView.setCellValueFactory(new PropertyValueFactory<>("expCompleteDate"));

        // Load data from maintenance.bin
        File maintenanceFile = new File("data/sakib/maintenance.bin");
        List<Maintenance> maintenanceList = BinaryFileHelper.readAllObjects(maintenanceFile);

        blockedVehicleListTableView.getItems().addAll(maintenanceList);
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerScheduleMaintenanceView.fxml", event);
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
}