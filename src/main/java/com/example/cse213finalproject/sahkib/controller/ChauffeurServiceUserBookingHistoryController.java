package com.example.cse213finalproject.sahkib.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.cse213finalproject.commonClass.SceneSwitch.switchScene;

public class ChauffeurServiceUserBookingHistoryController {
    @javafx.fxml.FXML
    private TableColumn interactionTypeCol;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private ComboBox typeComboBox;
    @javafx.fxml.FXML
    private TableColumn inspectionIdCol;
    @javafx.fxml.FXML
    private TableView historyTableView;
    @javafx.fxml.FXML
    private TableColumn historyIdCol;

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
