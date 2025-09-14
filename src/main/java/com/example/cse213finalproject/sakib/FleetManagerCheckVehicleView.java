package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.InspectionVehicle;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FleetManagerCheckVehicleView
{
    @javafx.fxml.FXML
    private DatePicker InspectionDateDatePicker;
    @javafx.fxml.FXML
    private TextField vehicleIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Vehicle,String> modelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Vehicle,String> typeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Vehicle,String> BrandTableColumn;
    @javafx.fxml.FXML
    private TableView<Vehicle> fleetTableView;
    @javafx.fxml.FXML
    private TableColumn<Vehicle,String > vehicleIDTableColumn;
    @javafx.fxml.FXML
    private TextField addInformationTextField;

    private File vehicleFile = new File("data/sakib/fleet.bin");
    private File inspectionFile = new File("data/sakib/inspectionVehicle.bin");

//   protected String vehicleID, vehicleModel, vehicleType, brand, status


    @javafx.fxml.FXML
    public void initialize() {

        modelTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
        vehicleIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        BrandTableColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));

        loadVehicleData();
    }

    public void loadVehicleData(){

        List<Vehicle> currentList = BinaryFileHelper.readAllObjects(vehicleFile);
        fleetTableView.getItems().clear();
        fleetTableView.getItems().addAll(currentList);


    }

    @javafx.fxml.FXML
    public void assignOnMouseClickedButton(Event event) {

//InspectionVehicle(String vehicleID, String brand, String status, String information, String comment, LocalDate inspectionDate)
        InspectionVehicle v = new InspectionVehicle(vehicleIDTextField.getText(),
                "Assigned",addInformationTextField.getText(),"N/A",
                InspectionDateDatePicker.getValue() );

        BinaryFileHelper.saveObject(inspectionFile,v);

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Vehicle Assigned for Inspection");
        a.showAndWait();

    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void trackInspectionOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerCheckInspectionData.fxml", event);
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