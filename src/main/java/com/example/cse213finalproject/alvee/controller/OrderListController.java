package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.sakibModelClass.Order;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class OrderListController
{
    @javafx.fxml.FXML
    private TableColumn<Order, Float> totalCoastCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> idCol;
    @javafx.fxml.FXML
    private TableView<Order> orderTableView;
    @javafx.fxml.FXML
    private TableColumn<LocalDate, String> dropOffDateCol;
    @javafx.fxml.FXML
    private TableColumn<LocalDate, String> pickUpDateCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> cNameCol;
    @javafx.fxml.FXML
    private TableColumn<Order, String> vehicleIdCol;

    @javafx.fxml.FXML
    public void initialize() {
        cNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        dropOffDateCol.setCellValueFactory(new PropertyValueFactory<>("dropOffDate"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        pickUpDateCol.setCellValueFactory(new PropertyValueFactory<>("pickupDate"));
        totalCoastCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        vehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));

        File file = new File("data/sakib/order.bin");
        List<Order> orderList = BinaryFileHelper.readAllObjects(file);

        orderTableView.getItems().addAll(orderList);
    }}