package com.example.cse213finalproject.sahkib.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.cse213finalproject.util.SceneSwitcher.switchScene;

public class ChauffeurServiceUserDashboardController {
    @javafx.fxml.FXML
    private Text csrName;

    @javafx.fxml.FXML
    public void BookingAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserBookingView.fxml", event);
    }

    @javafx.fxml.FXML
    public void bookingHistoryAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserBookingHistoryView.fxml", event);
    }

    @javafx.fxml.FXML
    public void cancelBookingAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserBookingCancelationView.fxml", event);
    }

    @javafx.fxml.FXML
    public void RateAndReviewAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserReviewView.fxml", event);
    }

    @javafx.fxml.FXML
    public void requestChauffeurAvailabilityAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserAvailabilityView.fxml", event);
    }

    @javafx.fxml.FXML
    public void updateChauffeurPreferenceAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserUpdateView.fxml", event);
    }

    @javafx.fxml.FXML
    public void viewChauffeurProfilesAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserProfileView.fxml", event);
    }

    @javafx.fxml.FXML
    public void chauffeurReportsAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserReportsView.fxml", event);
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





