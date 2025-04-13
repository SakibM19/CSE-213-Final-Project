package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.Complaint;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ComplaintListController
{
    @javafx.fxml.FXML
    private TableView<Complaint> reservationRequestTableView;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> complaintIdCol;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> customerNameCol;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> subjectCol;
    @javafx.fxml.FXML
    private TableColumn<Complaint, Void> actionCol;

    @javafx.fxml.FXML
    public void initialize() {
        complaintIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleFilterButtonOnClick(ActionEvent actionEvent) {
    }
}