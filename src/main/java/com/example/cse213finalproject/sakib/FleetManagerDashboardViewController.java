package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FleetManagerDashboardViewController
{
    @javafx.fxml.FXML
    private AnchorPane fleetManagerDashboardAnchorPane;
    @javafx.fxml.FXML
    private Text userIdText;
    @javafx.fxml.FXML
    private Text phoneNumText;
    @javafx.fxml.FXML
    private Text emailText;
    @javafx.fxml.FXML
    private Text nameText;

    @javafx.fxml.FXML
    public void initialize() {
        emailText.setText(SessionManager.getLoggedInFleetManager().getEmail());
        nameText.setText(SessionManager.getLoggedInFleetManager().getName());
        phoneNumText.setText(Integer.toString(SessionManager.getLoggedInFleetManager().getPhoneNumber()));
        userIdText.setText(SessionManager.getLoggedInFleetManager().getId());
    }


    @javafx.fxml.FXML
    public void trackVehicleOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerTrackVehicleStatusView.fxml", event);
    }

    @javafx.fxml.FXML
    public void manageFeedbackOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerFeedbackManageView.fxml", event);
    }


    @javafx.fxml.FXML
    public void blockVehicleOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerBlockVehicleView.fxml", event);
    }

    @javafx.fxml.FXML
    public void handelViolationOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerViolation.fxml", event);
    }

    @javafx.fxml.FXML
    public void manageVehicleOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerUpdateVehicleInSystemView.fxml", event);
    }

    @javafx.fxml.FXML
    public void trackMaintenanceOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerTrackMaintenanceView.fxml", event);
    }

    @javafx.fxml.FXML
    public void scheduleMaintenanceOnMouseClickedButton(Event event) {
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

    @javafx.fxml.FXML
    public void logoutOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/logInView.fxml", event);
    }

    @javafx.fxml.FXML
    public void assignInspectionOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerCheckVehicle.fxml", event);
    }
}