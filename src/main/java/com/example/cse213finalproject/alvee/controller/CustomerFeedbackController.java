package com.example.cse213finalproject.alvee.controller;
//
//import com.example.cse213finalproject.alvee.model.Feedback;
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.text.Text;
//
//public class CustomerFeedbackController {
//
//    @FXML
//    private TableColumn<Feedback, String> idCol;
//    @FXML
//    private TableColumn<Feedback, String> avgRatingCol;
//    @FXML
//    private TableColumn<Feedback, String> commentCol;
//    @FXML
//    private TableView<Feedback> feedbackTableView;
//    @FXML
//    private Label commentLabel;
//    @FXML
//    private Text carRatingText, cleanlinessRatingText, comfortRatingText;
//    @FXML
//    private TextField replyTextField;
//
//    private ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();
//
//    @FXML
//    public void initialize() {
//        // Set up column data (use PropertyValueFactory or lambdas)
//        idCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().feedbackId));
//        avgRatingCol.setCellValueFactory(cellData -> {
//            Feedback f = cellData.getValue();
//            int avg = (f.vehicleCondition + f.cleanliness + f.comfort) / 3;
//            return new ReadOnlyStringWrapper(String.valueOf(avg));
//        });
//        commentCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().additionalComment));
//
//        // Sample data (remove in real app)
//        feedbackList.addAll(
//                new Feedback("FB101", 4, 5, 4, "Nice car!", null),
//                new Feedback("FB102", 2, 3, 3, "Could be cleaner.", null)
//        );
//
//        feedbackTableView.setItems(feedbackList);
//
//        // Handle row click
//        feedbackTableView.setOnMouseClicked(event -> {
//            Feedback selected = feedbackTableView.getSelectionModel().getSelectedItem();
//            if (selected != null) {
//                showFeedbackDetails(selected);
//            }
//        });
//    }
//
//    private Feedback currentFeedback; // to track selected item
//
//    private void showFeedbackDetails(Feedback feedback) {
//        currentFeedback = feedback;
//
//        carRatingText.setText(String.valueOf(feedback.vehicleCondition));
//        cleanlinessRatingText.setText(String.valueOf(feedback.cleanliness));
//        comfortRatingText.setText(String.valueOf(feedback.comfort));
//        commentLabel.setText(feedback.additionalComment);
//        replyTextField.setText(feedback.csrReply != null ? feedback.csrReply : "");
//    }
//
//    @FXML
//    public void handleSendButtonOnAction(ActionEvent event) {
//        if (currentFeedback != null) {
//            currentFeedback.csrReply = replyTextField.getText();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText("Reply sent!");
//            alert.setContentText("Your reply was saved to feedback ID: " + currentFeedback.feedbackId);
//            alert.showAndWait();
//        }
//    }
//}
