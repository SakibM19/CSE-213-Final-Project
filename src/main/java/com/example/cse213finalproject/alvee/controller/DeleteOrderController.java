package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Order;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.List;

public class DeleteOrderController
{
    @javafx.fxml.FXML
    private TextField orderIdTextField;
    private List<Order> orderList;

    @javafx.fxml.FXML
    public void initialize() {
        File orderFile = new File("data/alvee/order.bin");
        this.orderList = BinaryFileHelper.readAllObjects(orderFile);
    }

    @javafx.fxml.FXML
    public void handleCancelButtonOnClick(ActionEvent actionEvent) {
        for (Order o: orderList){
            if (o.getOrderID().equals(orderIdTextField.getText())){
                orderList.remove(o);
                break;
            }
        }

        BinaryFileHelper.writeAllObjects(new File("data/sakib/order.bin"), orderList);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "order-list.fxml", "Order List");
    }
}