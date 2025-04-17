package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
    private ComboBox<String> statusComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pending", "Resolved");

        requestIdCol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        querySubCol.setCellValueFactory(new PropertyValueFactory<>("querySub"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        File file = new File("data/alvee/customer-query.bin");
        List<CustomerQuery> queries = BinaryFileHelper.readAllObjects(file);

        reservationRequestTableView.getItems().addAll(queries);

    }


    @javafx.fxml.FXML
    public void handleFilterButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/cse213finalproject/alvee/csr-dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("CSR Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Optional: replace with proper alert or logging
        }
    }

    @javafx.fxml.FXML
    public void handleReplyQueriesButtonOnClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/cse213finalproject/alvee/query-details.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Query Requests");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Optional: replace with proper alert or logging
        }
    }
}