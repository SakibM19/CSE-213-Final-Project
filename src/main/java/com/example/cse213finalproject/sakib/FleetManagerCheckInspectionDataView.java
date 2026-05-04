package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.InspectionVehicle;
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

public class FleetManagerCheckInspectionDataView
{
    @javafx.fxml.FXML
    private TableColumn<InspectionVehicle,String> statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<InspectionVehicle,String> informationTableColumn;
    @javafx.fxml.FXML
    private TableView<InspectionVehicle> inspectionTableView;
    @javafx.fxml.FXML
    private TableColumn<InspectionVehicle,String> commentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<InspectionVehicle,LocalDate> dateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<InspectionVehicle,String> vehicleIDTableColumn;

    private File vehicleFile = new File("data/sakib/inspectionVehicle.bin");
//public InspectionVehicle(String vehicleID, String status, String information, String comment, LocalDate inspectionDate) {
    @javafx.fxml.FXML
    public void initialize() {
        loadData();
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        informationTableColumn.setCellValueFactory(new PropertyValueFactory<>("information"));
        commentTableColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        vehicleIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("inspectionDate"));
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerCheckVehicle.fxml", event);
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

    private void loadData(){

        List<InspectionVehicle> vList = BinaryFileHelper.readAllObjects(vehicleFile);
        inspectionTableView.getItems().clear();
        inspectionTableView.getItems().addAll(vList);

    }
}