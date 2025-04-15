package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerOfferAndVouchersViewController
{
    @javafx.fxml.FXML
    private TextField enterVoucherCodeTextField;
    @javafx.fxml.FXML
    private TableView offerAndVoucherTableView;
    @javafx.fxml.FXML
    private TextField enterOrderIdTextField;
    @javafx.fxml.FXML
    private TableColumn applicableBookingIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn offerDetailTableColumn;
    @javafx.fxml.FXML
    private TableColumn offerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn voucherTableColumn;
    @javafx.fxml.FXML
    private TableColumn offerDeadlineTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void RedeemOnMouseClickedButton(Event event) {
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