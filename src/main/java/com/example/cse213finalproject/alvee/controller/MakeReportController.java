package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.FeedbackReport;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.util.List;

public class MakeReportController
{
    @javafx.fxml.FXML
    private ComboBox<String> feedbackTypeComboBox;
    @javafx.fxml.FXML
    private TextArea summaryReportTextArea;
    @javafx.fxml.FXML
    private TableView<FeedbackReport> reportTableView;
    @javafx.fxml.FXML
    private TableColumn<FeedbackReport, String> feedbackTypeCol;
    @javafx.fxml.FXML
    private TableColumn<FeedbackReport, String> summaryCol;
    private List<FeedbackReport> feedbackReportList;

    @javafx.fxml.FXML
    public void initialize() {
        this.feedbackReportList = BinaryFileHelper.readAllObjects(new File("data/alvee/feedback-report.bin"));

        feedbackTypeComboBox.getItems().addAll("Staff Behavior", "Vehicle Related");

        feedbackTypeCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        summaryCol.setCellValueFactory(new PropertyValueFactory<>("reportText"));
        reportTableView.getItems().addAll(feedbackReportList);
    }

    @javafx.fxml.FXML
    public void handleSaveButtonOnAction(ActionEvent actionEvent) {
        FeedbackReport feedbackReport = new FeedbackReport(feedbackTypeComboBox.getValue(), summaryReportTextArea.getText());
        feedbackReportList.add(feedbackReport);
        BinaryFileHelper.writeAllObjects(new File("data/alvee/feedback-report.bin"), feedbackReportList);
        reportTableView.getItems().add(feedbackReport);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "customer-feedback.fxml", "Interaction History");
    }
}