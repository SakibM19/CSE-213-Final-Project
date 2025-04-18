package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class FleetManagerCustomerViolationViewController
{
    @javafx.fxml.FXML
    private ComboBox statusSelectionComboBox;
    @javafx.fxml.FXML
    private TextField enterCustomerIdForStatusTextField;
    @javafx.fxml.FXML
    private TableView violationTableView;
    @javafx.fxml.FXML
    private TextField enterCustomerIdTextField;
    @javafx.fxml.FXML
    private TextArea violationDetailTextArea;
    @javafx.fxml.FXML
    private TableColumn orderIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn cuttentStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn vehicleIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn customerIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn violationIdTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void loadViolationDetailOnMouseClickedButton(Event event) {
    }

    @javafx.fxml.FXML
    public void refreshOnMouseClickedButton(Event event) {
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