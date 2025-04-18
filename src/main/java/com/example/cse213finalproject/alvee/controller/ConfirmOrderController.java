package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class ConfirmOrderController
{
    @javafx.fxml.FXML
    private TableColumn<Booking, String> bookingIdCol;
    @javafx.fxml.FXML
    private TableColumn<Booking, String> customerNameCol;
    @javafx.fxml.FXML
    private TableColumn<Booking, LocalDate> dropOffDateCol;
    @javafx.fxml.FXML
    private TableColumn<Booking, String> vehicleModelCol;
    @javafx.fxml.FXML
    private TableColumn<Booking, LocalDate> pickUpDateCol;
    @javafx.fxml.FXML
    private TableView<Booking> bookingListTableView;

    @javafx.fxml.FXML
    public void initialize() {
        bookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        dropOffDateCol.setCellValueFactory(new PropertyValueFactory<>("dropOffDate"));
        pickUpDateCol.setCellValueFactory(new PropertyValueFactory<>("pickupDate"));
        vehicleModelCol.setCellValueFactory(new PropertyValueFactory<>("vehicleName"));

        File file = new File("data/sakib/booking.bin");
        List<Booking> bookingList = BinaryFileHelper.readAllObjects(file);

        bookingListTableView.getItems().addAll(bookingList);
    }

    @javafx.fxml.FXML
    public void handleGoToConfirmButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "confirmation-detail.fxml", "Confirm Booking");
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnAction(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "CSR-dashboard.fxml", "Dashboard");
    }
}