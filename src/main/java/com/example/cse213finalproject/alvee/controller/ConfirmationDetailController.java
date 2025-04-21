package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.sakibModelClass.Order;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.OrderIdGenerator;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class ConfirmationDetailController
{
    @FXML
    private Text carNameText;
    @FXML
    private Text startDateText;
    @FXML
    private TextField bookingIdTextField;
    @FXML
    private Text customerNameText;
    @FXML
    private Text endDateText;
    private List<Booking> bookingList;
    private Booking b;
    private List<Vehicle> vehicleList;
    private List<Order> orderList;

    @FXML
    public void initialize() {
        File bookingFile = new File("data/sakib/booking.bin");
        this.bookingList = BinaryFileHelper.readAllObjects(bookingFile);

        File vehicleFile = new File("data/sakib/fleet.bin");
        this.vehicleList = BinaryFileHelper.readAllObjects(vehicleFile);

        File file = new File("data/sakib/order.bin");
        this.orderList = BinaryFileHelper.readAllObjects(file);
    }

    @FXML
    public void handleConfirmButtonOnAction(ActionEvent actionEvent) {
        float perDayCost = 0;
        for (Vehicle v: vehicleList) {
            if (v.getVehicleID().equals(b.getVehicleId())){
                perDayCost = v.getPerDayCost();
                break;
            }
        }
//        String customerName, String orderID, String bookingID, String customerID, LocalDate pickupDate, LocalDate dropOffDate,String vehicleId, String vehicleModel,  float dailyCost
        Order o = new Order(
                b.getCustomerName(),
                OrderIdGenerator.generateOrderId(),
                b.getBookingID(),
                b.getCustomerID(),
                b.getPickupDate(),
                b.getDropOffDate(),
                b.getVehicleId(),
                b.getVehicleModel(),
                perDayCost
        );
        orderList.add(o);

        File file = new File("data/sakib/order.bin");
        BinaryFileHelper.writeAllObjects(file, orderList);

        bookingList.remove(b);
        BinaryFileHelper.writeAllObjects(new File("data/sakib/booking.bin"), bookingList);
    }

    @FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "csr-dashboard.fxml", "Confirm Booking");
    }

    @FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
        for (Booking b: bookingList){
            if (bookingIdTextField.getText().equals(b.getBookingID())){
                customerNameText.setText(b.getCustomerName());
                carNameText.setText(b.getVehicleModel());
                startDateText.setText(b.getPickupDate().toString());
                endDateText.setText(b.getDropOffDate().toString());
                this.b = b;
                break;
            }
        }
   }
}