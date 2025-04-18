package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.collections.FXCollections;
import javafx.event.Event;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomerTrackBookingViewController implements SceneSwitch
{
    @javafx.fxml.FXML
    private TableView<Booking> trackBookingTableView;
    @javafx.fxml.FXML
    private TableColumn<Booking, String> activeBookingIdTableColumn;
    @javafx.fxml.FXML
    private TextField idForTrackingTextField;
    @javafx.fxml.FXML
    private TextField customerIDTextfield;

    @javafx.fxml.FXML
    public void initialize() {
        activeBookingIdTableColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("bookingID"));
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        SceneSwitch.switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void trackBookingOnMouseClickedButton(Event event) {
        SceneSwitch.switchScene("/com/example/cse213finalproject/sakib/CustomerCurrentBookingStatusView.fxml", event);
    }


    @javafx.fxml.FXML
    public void loadOnMouseClickedButton(Event event) {
        String enteredCustomerId = customerIDTextfield.getText(); // Get the entered customer ID
        File bookingFile = new File("data/sakib/booking.bin");

        // Read all bookings from the binary file
        List<Booking> allBookings = BinaryFileHelper.readAllObjects(bookingFile);

        List<Booking> customerBookings = new ArrayList<>(); // Create a list to hold the filtered bookings

        // Loop through each booking and check if the customer ID matches
        for (Booking booking : allBookings) {
            if (booking.getCustomerId().equals(enteredCustomerId)) {
                customerBookings.add(booking); // Add the booking to the list if the IDs match
            }
        }

        // Set the filtered bookings in the TableView
        trackBookingTableView.setItems(FXCollections.observableArrayList(customerBookings));
    }

}
