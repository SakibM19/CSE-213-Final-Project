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
    private Menu logOutMenu;
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


    @Deprecated
    public void logOutOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
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
    public void manageRefundOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerRefundClaimsView.fxml", event);
    }

    @javafx.fxml.FXML
    public void blockVehicleOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerBlockVehicleView.fxml", event);
    }

    @javafx.fxml.FXML
    public void handelViolationOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerCustomerViolationView.fxml", event);
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

    @javafx.fxml.FXML
    public void logOutOnActionMenu(ActionEvent actionEvent) {


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