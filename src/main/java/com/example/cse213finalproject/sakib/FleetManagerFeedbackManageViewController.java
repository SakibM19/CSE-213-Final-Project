package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Feedback;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FleetManagerFeedbackManageViewController
{
    @javafx.fxml.FXML
    private TextField enterVehicleIDTextField;
    @javafx.fxml.FXML
    private Label vehicleIDLable;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String > customerIDTableColumn;
    @javafx.fxml.FXML
    private Label comfortLable;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTableView;
    @javafx.fxml.FXML
    private Label vehicleConditionLable;
    @javafx.fxml.FXML
    private Label additionalLable;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String > vehicleIDTableColumn;
    @javafx.fxml.FXML
    private Label cleanlinessLable;
    @javafx.fxml.FXML
    private Label customerIDLable;

    private final File feedbackFile = new File("data/sakib/feedback.bin");

    @javafx.fxml.FXML
    public void initialize() {
        vehicleIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        customerIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));

        loadFeedbackTable();
    }

    private void loadFeedbackTable() {
        List<Feedback> allFeedback = BinaryFileHelper.readAllObjects(feedbackFile);
        feedbackTableView.getItems().setAll(allFeedback);
    }


    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/fleetManagerDashboardView.fxml", event);
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
    public void lookAtFeedbackOnMouseClickedButton(Event event) {

        List<Feedback> allFeedback = BinaryFileHelper.readAllObjects(feedbackFile);

        for(Feedback f : allFeedback){
            if (f.getVehicleID().equals(enterVehicleIDTextField.getText())) {
                vehicleIDLable.setText(f.getVehicleID());
                customerIDLable.setText(f.getCustomerID());
                comfortLable.setText(String.valueOf(f.getComfort()));
                cleanlinessLable.setText(String.valueOf(f.getCleanliness()));
                vehicleConditionLable.setText(String.valueOf(f.getVehicleCondition()));
                additionalLable.setText(f.getAdditionalComment());
                return;
            }
        }
    }
}