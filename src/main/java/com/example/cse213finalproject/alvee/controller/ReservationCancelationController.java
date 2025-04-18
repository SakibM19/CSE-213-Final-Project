package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.util.List;

public class ReservationCancelationController
{
    @javafx.fxml.FXML
    private Text carNameText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private TextField bookingIdTextField;
    @javafx.fxml.FXML
    private Text customerNameText;
    @javafx.fxml.FXML
    private Text endDateText;
    private List<Booking> bookingList;
    private Booking b;

    @javafx.fxml.FXML
    public void initialize() {
        File file = new File("data/sakib/booking.bin");
        this.bookingList = BinaryFileHelper.readAllObjects(file);
    }

    @javafx.fxml.FXML
    public void handleCancelBookingButtonOnClick(ActionEvent actionEvent) {
        if (b == null) return;

        bookingList.removeIf(booking -> booking.getBookingID().equals(b.getBookingID()));

        File file = new File("data/sakib/booking.bin");
        BinaryFileHelper.writeAllObjects(file, bookingList);

        customerNameText.setText("");
        carNameText.setText("");
        startDateText.setText("");
        endDateText.setText("");
        bookingIdTextField.setText("");

        b = null; // Clear reference
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "CSR-dashboard.fxml", "Dashboard");
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
        for (Booking b: bookingList){
            if (bookingIdTextField.getText().equals(b.getBookingID())){
                customerNameText.setText(b.getCustomerName());
                carNameText.setText(b.getVehicleName());
                startDateText.setText(b.getPickupDate().toString());
                endDateText.setText(b.getDropOffDate().toString());
                this.b = b;
                break;
            }
        }
    }
}