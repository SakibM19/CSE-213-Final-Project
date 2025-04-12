package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.ReservationRequest;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReservationRequestListController
{
    @javafx.fxml.FXML
    private TableView<ReservationRequest> reservationRequestTableView;
    @javafx.fxml.FXML
    private TableColumn<ReservationRequest, String> requestTypeCol;
    @javafx.fxml.FXML
    private TableColumn<ReservationRequest, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<ReservationRequest, String> requestIdCol;
    @javafx.fxml.FXML
    private TableColumn<ReservationRequest, String> customerNameCol;
    @javafx.fxml.FXML
    private ComboBox<String> StatusComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleFilterButtonOnClick(ActionEvent actionEvent) {
    }
}