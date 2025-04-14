package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.SupportReport;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class GenerateReportController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private Text totalTicketsText;
    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> statusCol;
    @javafx.fxml.FXML
    private Text resolvedTicketText;
    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> ticketIdCol;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableView<SupportReport> ticketsTableView;
    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> issueTypeCol;
    @javafx.fxml.FXML
    private TableColumn<SupportReport, LocalDate> resolutionTimeCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleGenerateReportButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleExportOnAction(ActionEvent actionEvent) {
    }
}