package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.alvee.model.ReservationRequest;
import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.File;
import java.util.List;

public class ReservationRequestListController
{

    @javafx.fxml.FXML
    private Text carNameText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private Text customerNameText;
    @javafx.fxml.FXML
    private Text endDateText;
    @javafx.fxml.FXML
    private ComboBox<String> AvailableCarComboBox;
    @javafx.fxml.FXML
    private TextField bookingIdTextField;
//    private Booking b;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "csr-dashboard.fxml", "Dashboard");
    }

    @javafx.fxml.FXML
    public void handleUpdateButtonOnClick(ActionEvent actionEvent) {

    }


    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
        File file = new File("data/sakib/booking.bin");
        List<Booking> bookingList = BinaryFileHelper.readAllObjects(file);
        for (Booking b: bookingList){
            if (Integer.parseInt(bookingIdTextField.getText()) == b.getBookingID()){
                customerNameText.setText(b.getCustomerName());
                carNameText.setText(b.getVehicleName());
                startDateText.setText(b.getPickupDate().toString());
                endDateText.setText(b.getDropOffDate().toString());
//                this.b = b;
                break;
            }
        }

    }
}