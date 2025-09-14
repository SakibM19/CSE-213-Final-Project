package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Feedback;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.util.List;

public class CustomerFeedbackController
{
    @javafx.fxml.FXML
    private TableColumn<Feedback, Integer> vehicleRatingCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> shortNoteCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback, Integer> comfortRatingCol;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTableView;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> customerIdCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> vehicleIdCol;
    private List<Feedback> feedbackList;

    @javafx.fxml.FXML
    public void initialize() {
        this.feedbackList = BinaryFileHelper.readAllObjects(new File("data/sakib/feedback.bin"));

        comfortRatingCol.setCellValueFactory(new PropertyValueFactory<>("comfort"));
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        shortNoteCol.setCellValueFactory(new PropertyValueFactory<>("additionalComment"));
        vehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        vehicleRatingCol.setCellValueFactory(new PropertyValueFactory<>("vehicleCondition"));

        feedbackTableView.getItems().addAll(feedbackList);
    }

    @javafx.fxml.FXML
    public void handleReportButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "make-report.fxml", "Make Report");
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "CSR-dashboard.fxml", "Dashboard");
    }
}