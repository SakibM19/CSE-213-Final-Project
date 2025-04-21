package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.sakibModelClass.Order;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.OrderIdGenerator;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
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
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class CustomerPlaceOrderInformationViewController
{
    @javafx.fxml.FXML
    private DatePicker dropoffDatePicker;
    @javafx.fxml.FXML
    private DatePicker pickupDatePicker;
    @javafx.fxml.FXML
    private TextField dropoffLocationTextField;
    @javafx.fxml.FXML
    private TextField pickupLocationTextField;


    private

    Customer current = SessionManager.getLoggedInCustomer();
    @javafx.fxml.FXML
    private CheckBox locationCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> brandComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleModelComboBox;
    private List<Vehicle> vehicleList;
//    private  availableBrand;
    private final List<Vehicle> availableVehicle = new ArrayList<>();
    private List<String> modelOfSelectedBrand;

    @javafx.fxml.FXML
    public void initialize() {
        List<String> availableBrand = new ArrayList<>();
        this.modelOfSelectedBrand = new ArrayList<>();
        this.vehicleList = BinaryFileHelper.readAllObjects(new File("data/sakib/fleet.bin"));
        for (Vehicle v: vehicleList){
            if (v.getStatus().equals("Available")){
                availableBrand.add(v.getBrand());
                availableVehicle.add(v);
            }
        }
        Set<String> removedDuplicate = new LinkedHashSet<>(availableBrand);
        availableBrand.clear();
        availableBrand.addAll(removedDuplicate);
        brandComboBox.getItems().addAll(availableBrand);

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
        String orderId = OrderIdGenerator.generateOrderId();
        String customerName = current.getName();
        float cost = 10000f;  // no database so I am considering a fixed amount.

        Vehicle selectedV = new Vehicle();
        for (Vehicle v: vehicleList){
            if (vehicleModelComboBox.getValue().equals(v.getVehicleModel())){
                selectedV = v;
                break;
            }
        }


//        String customerName, String orderID, String customerID, LocalDate pickupDate, LocalDate dropOffDate, float dailyCost, String vehicleId, String vehicleBrand
        Order currentorder = new Order(
                customerName,
                orderId,
                customerId,
                pd,
                dd,
                selectedV.getPerDayCost(),
                selectedV.getVehicleID(),
                selectedV.getVehicleModel()
        );

        File orderFile = new File("data/sakib/order.bin");
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
        String bookingId = OrderIdGenerator.generateBookingId();
        String customerName = current.getName();
        int cost = 10000;  // Fixed cost as mentioned
        String vId = "";
        for (Vehicle v: vehicleList){
            if (vehicleModelComboBox.getValue().equals(v.getVehicleModel())){
                vId = v.getVehicleID();
                break;
            }
        }

//        int totalCost, String customerName, String customerId, String bookingID, LocalDate pickupDate, LocalDate dropOffDate, String vehicleId, String vehicleModel


        Booking currentBooking = new Booking(
                cost,
                customerName,
                customerId,
                bookingId,
                pd,
                dd,
                vId,
                vehicleModelComboBox.getValue()
        );

        File bookFile = new File("data/sakib/booking.bin");
        List<Booking> bookingList = BinaryFileHelper.readAllObjects(bookFile);
        bookingList.add(currentBooking);
        BinaryFileHelper.writeAllObjects(bookFile, bookingList);


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Booking Confirmed");
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void handleGetModelOnAction(ActionEvent actionEvent) {
        modelOfSelectedBrand.clear();
        for (Vehicle v: availableVehicle){
            if (v.getBrand().equals(brandComboBox.getValue())){
                modelOfSelectedBrand.add(v.getVehicleModel());
            }
        }
        vehicleModelComboBox.getItems().clear();
        vehicleModelComboBox.getItems().addAll(modelOfSelectedBrand);
    }
}