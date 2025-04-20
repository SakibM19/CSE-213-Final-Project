package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.sakibModelClass.Order;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.Event;
import javafx.scene.control.*;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class CustomerPlaceOrderInformationViewController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> seatsWantedComboBox;
    @javafx.fxml.FXML
    private DatePicker dropoffDatePicker;
    @javafx.fxml.FXML
    private DatePicker pickupDatePicker;
    @javafx.fxml.FXML
    private TextField dropoffLocationTextField;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeWantedComboBox;
    @javafx.fxml.FXML
    private TextField pickupLocationTextField;


    private File bookFile = new File("data/sakib/booking.bin");
    private File orderFile = new File("data/sakib/order.bin");
    Customer current = SessionManager.getLoggedInCustomer();
    @javafx.fxml.FXML
    private CheckBox locationCheckBox;

    @javafx.fxml.FXML
    public void initialize() {

        seatsWantedComboBox.getItems().addAll(2, 5, 7);
        vehicleTypeWantedComboBox.getItems().addAll("Sedan","SUV");

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

    private String generate4DigitRandomNumber() {
        int randomNum = (int)(Math.random() * 9000) + 1000;
        return String.valueOf(randomNum);
    }

    @javafx.fxml.FXML
    public void placeOrderOnMouseClickedButton(Event event) {

        if (locationCheckBox.isSelected()){
            String dl = current.getDropOffLocation();
            String pl = current.getPickUpLocation();

        }else{

            String dl = dropoffLocationTextField.getText();
            String pl = pickupLocationTextField.getText();
        }

        LocalDate dd = dropoffDatePicker.getValue();
        LocalDate pd = pickupDatePicker.getValue();

        String customerId = current.getId();
        String bookingId = "b" + customerId + generate4DigitRandomNumber();
        String orderId = "o" + customerId + generate4DigitRandomNumber();
        String customerName = current.getName();
        Float cost = 10000f;  // no database so I am considering a fixed amount.

        Order currentorder = new Order(
                customerName,
                orderId,
                bookingId,
                customerId,
                pd,
                dd,
                cost
        );


        List<Order> orderList = BinaryFileHelper.readAllObjects(orderFile);
        orderList.add(currentorder);
        BinaryFileHelper.writeAllObjects(orderFile,orderList);


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Order Confirmed");
        a.showAndWait();

    }

    @javafx.fxml.FXML
    public void createBookingOnMouseClickedButton(Event event) {
        String dl = dropoffLocationTextField.getText();
        String pl = pickupLocationTextField.getText();

        LocalDate dd = dropoffDatePicker.getValue();
        LocalDate pd = pickupDatePicker.getValue();

        String customerId = current.getId();
        String bookingId = "b" + customerId + generate4DigitRandomNumber();
        String orderId = "o" + customerId + generate4DigitRandomNumber();
        String customerName = current.getName();
        Integer cost = 10000;  // Fixed cost as mentioned


        Booking currentBooking = new Booking(
                cost,
                customerName,
                customerId,
                bookingId,
                pd,
                dd
        );

        List<Booking> bookingList = BinaryFileHelper.readAllObjects(bookFile);
        bookingList.add(currentBooking);
        BinaryFileHelper.writeAllObjects(bookFile, bookingList);


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Booking Confirmed");
        a.showAndWait();
    }

}