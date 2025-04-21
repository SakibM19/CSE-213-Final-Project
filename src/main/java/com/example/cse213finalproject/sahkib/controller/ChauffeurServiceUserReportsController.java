package com.example.cse213finalproject.sahkib.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.cse213finalproject.commonClass.SceneSwitch.switchScene;

public class ChauffeurServiceUserReportsController {
    @javafx.fxml.FXML
    private Text carNameText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private TextField bookingIdTextField;
    @javafx.fxml.FXML
    private Text customerNameText;
    @javafx.fxml.FXML
    private Text endDateText;

    @javafx.fxml.FXML
    public void backAction(ActionEvent actionEvent) {
        switchScene("/com/example/cse213finalproject/sahkib/ChauffeurServiceUserDashBoardView.fxml", event);
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
