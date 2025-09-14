package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Order;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;


import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CustomerOrderListForPaymentViewController
{
    @javafx.fxml.FXML
    private TextField paymentIDinputTextField;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order, Float> amountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order, LocalDate> paymentDeadlineTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> orderListTableView;

    private File orderFile = new File("data/sakib/order.bin");


    @javafx.fxml.FXML
    public void initialize() {

        loadOrderData();

        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        paymentDeadlineTableColumn.setCellValueFactory((new PropertyValueFactory<>("pickupDate")));

    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
    }

    public void loadOrderData(){
        List<Order> orderList = BinaryFileHelper.readAllObjects(orderFile);
        orderListTableView.getItems().clear();
        orderListTableView.getItems().addAll(orderList);
    }

    @javafx.fxml.FXML
    public void makePaymentOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/customerPaymentMethodSelectView.fxml", event);

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