package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.sakibModelClass.Feedback;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SessionManager;
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
import java.util.List;

public class CustomerFeedbackBookingListViewController {

    @javafx.fxml.FXML
    private TextField additionalCommentsTextField;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> additionalCommentTableColumn;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTableView;
    @javafx.fxml.FXML
    private ComboBox<Integer> comfortComboBox;
    @javafx.fxml.FXML
    private TableColumn<Feedback, Integer> cleanlinessTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> vehicleNumberTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Feedback, Integer> comfortTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Feedback, Integer> vehicleConditionTableColumn;
    @javafx.fxml.FXML
    private ComboBox<Integer> vehicleConditionComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> cleanlinessComboBox;
    @javafx.fxml.FXML
    private TextField vehicleIdInputTextField;
    private List<Feedback> feedbackList;


    @javafx.fxml.FXML
    public void initialize() {
        this.feedbackList = BinaryFileHelper.readAllObjects(new File("data/sakib/feedback.bin"));
        vehicleNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        cleanlinessTableColumn.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));
        comfortTableColumn.setCellValueFactory(new PropertyValueFactory<>("comfort"));
        vehicleConditionTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleCondition"));
        additionalCommentTableColumn.setCellValueFactory(new PropertyValueFactory<>("additionalComment"));


        cleanlinessComboBox.getItems().addAll(1, 2, 3, 4, 5);
        comfortComboBox.getItems().addAll(1, 2, 3, 4, 5);
        vehicleConditionComboBox.getItems().addAll(1, 2, 3, 4, 5);

        loadFeedbackTable();
    }

    @javafx.fxml.FXML
    public void submitFeedbackOnMouseClickedButton(Event event) {
        Customer current = SessionManager.getLoggedInCustomer();

        String vehicleID = vehicleIdInputTextField.getText();
        Integer comfort = comfortComboBox.getValue();
        Integer cleanliness = cleanlinessComboBox.getValue();
        Integer vehicleCondition = vehicleConditionComboBox.getValue();
        String additionalComments = additionalCommentsTextField.getText();


        Feedback feedback = new Feedback(current.getId(), vehicleID, vehicleCondition, cleanliness, comfort, additionalComments);


        feedbackList.add(feedback);
        BinaryFileHelper.writeAllObjects(new File("data/sakib/feedback.bin"),feedbackList);


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Feedback given");
        a.showAndWait();


        loadFeedbackTable();
    }

    private void loadFeedbackTable() {
        feedbackTableView.getItems().clear();
        feedbackTableView.getItems().addAll(feedbackList);
    }


    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
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
