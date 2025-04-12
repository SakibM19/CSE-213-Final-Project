package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CustomerQuery;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class QueryRequestListController
{
    @javafx.fxml.FXML
    private TableView<CustomerQuery> reservationRequestTableView;
    @javafx.fxml.FXML
    private TableColumn<CustomerQuery, String> querySubCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerQuery, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerQuery, String> requestIdCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerQuery, String> customerNameCol;
    @javafx.fxml.FXML
    private TableColumn<CustomerQuery, String> csrNameCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleFilterButtonOnClick(ActionEvent actionEvent) {
    }
}